package com.movies.frameworks.commonsv1.utlis;

public class ResizeImage {
    public static final String ORIGINAL_SIZE = "";
    public static final String IMAGE_SIZE_SMALL = "-100-100";
    public static final String IMAGE_SIZE_MEDIUM = "-150-150";
    public static final String IMAGE_SIZE_LARGE = "-350-350";
    public static final String IMAGE_SIZE_XLARGE = "-450-450";
    public static final String IMAGE_SIZE_XXLARGE = "-1024-1024";

    public static String resizeImage(String url, String mode) {
        try {
            String auxUrl = url.replace("//", "");
            String[] urlComponents = auxUrl.split("/"); // Se divide la url
            if (urlComponents.length != 5) {
                return url;
            } else {
                String urlSize = urlComponents[3];
                String idImage = urlSize.split("-")[0];
                return url.replace(urlSize, idImage.concat(mode));
            }
        } catch (Exception e) {
            return url;
        }
    }
}
