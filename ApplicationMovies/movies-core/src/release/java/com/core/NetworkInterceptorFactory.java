package com.core;


import androidx.annotation.Nullable;

import com.core.util.SSLPinningEntity;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;

public class NetworkInterceptorFactory {
    /*
         Commands to generate sha256 for a certificate on mac
         #Creating certificate from remote URL and writing to file (mycertfile.pem)
         openssl s_client -showcerts -connect api.smdigital.cl:8443 </dev/null 2>/dev/null|openssl x509 -outform PEM >mycertfile.pem

         #Generating SHA256 hash of public key from a certificate (mycertfile.pem)
         openssl x509 -in mycertfile.pem -pubkey -noout | openssl rsa -pubin -outform der | openssl dgst -sha256 -binary | openssl enc -base64
          */

    public OkHttpClient getOkHttpClient() {
        Gson gson = new Gson();
        SSLPinningEntity sslPinningEntity = gson.fromJson(
                FirebaseRemoteConfig.getInstance().getString(RemoteConfigKeys.certificatePinner.name()),
                SSLPinningEntity.class
        );

        if (sslPinningEntity.isEnable()) {
            try {
                String domain = "api.smdigital.cl";
                CertificatePinner certificatePinner = new CertificatePinner.Builder()
                        .add(domain, sslPinningEntity.getCertificate())
                        .build();
                return getOkHttpBuilder(certificatePinner).build();
            } catch (Exception e) {
                return getOkHttpBuilder(null).build();
            }
        } else {
            return getOkHttpBuilder(null).build();
        }
    }

    private OkHttpClient.Builder getOkHttpBuilder(@Nullable CertificatePinner certificatePinner) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS);
        if (certificatePinner != null) {
            builder.certificatePinner(certificatePinner);
        }
        return builder;
    }
}
