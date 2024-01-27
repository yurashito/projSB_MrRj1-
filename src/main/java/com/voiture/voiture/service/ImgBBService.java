package com.voiture.voiture.service;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

// @Service
// public class ImgBBService {

//     @Value("${imgbb.api-key}")
//     private String apiKey;

//     private final WebClient webClient;

//     @Autowired
//     public ImgBBService(WebClient.Builder webClientBuilder) {
//         this.webClient = webClientBuilder.baseUrl("https://api.imgbb.com/1").build();
//     }

//     // public String uploadImage(byte[] imageData) {
//     //     MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
//     //     body.add("key", apiKey);
//     //     body.add("image", new ByteArrayResource(imageData));

//     //     return webClient.post()
//     //             .uri("/upload")
//     //             .contentType(MediaType.MULTIPART_FORM_DATA)
//     //             .body(BodyInserters.fromMultipartData(body))
//     //             .retrieve()
//     //             .bodyToMono(ImgBBResponse.class)
//     //             .map(ImgBBResponse::getData)
//     //             .map(ImgBBData::getUrl)
//     //             .block();  
//     // }

    

    

//     // public String uploadLocalImage(String localImagePath) throws Exception {
//     //     byte[] imageData = readImageAsBytes(localImagePath);

//     //     MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
//     //     body.add("key", apiKey);
//     //     body.add("image", new ByteArrayResource(imageData));

//     //     return webClient.post()
//     //             .uri("/upload")
//     //             .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
//     //             .body(BodyInserters.fromMultipartData(body))
//     //             .retrieve()
//     //             .bodyToMono(ImgBBResponse.class)
//     //             .map(ImgBBResponse::getData)
//     //             .map(ImgBBData::getUrl)
//     //             .block();
//     // }


//     // private byte[] readImageAsBytes(String imagePath) throws Exception {
//     //     Path path = Path.of(imagePath);
//     //     return Files.readAllBytes(path);
//     // }

//     public String uploadLocalImage(String localImagePath) throws Exception {
//         try {
//             byte[] imageData = Files.readAllBytes(Paths.get(localImagePath));
//             String base64Image = Base64.getEncoder().encodeToString(imageData);
    
//             MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
//             body.add("key", apiKey);
//             body.add("image", base64Image);
    
//             return webClient.post()
//                     .uri("/upload")
//                     .contentType(MediaType.MULTIPART_FORM_DATA)
//                     .body(BodyInserters.fromMultipartData(body))
//                     .retrieve()
//                     .bodyToMono(ImgBBResponse.class)
//                     .map(ImgBBResponse::getData)
//                     .map(ImgBBData::getUrl)
//                     .block();
//         } catch (WebClientResponseException ex) {
//             String responseBody = ex.getResponseBodyAsString();
//             System.out.println("Erreur ImgBB - Corps de la réponse : " + responseBody);
    
//             // Gérez l'erreur en conséquence
//             return "Error uploading image. ImgBB response: " + responseBody;
//         } catch (Exception e) {
//             // Gérer d'autres exceptions
//             e.printStackTrace();
//             return "Error uploading image. Exception: " + e.getMessage();
//         }
//     }
    

//     // public String uploadLocalImage(String localImagePath) throws Exception {
//     //     byte[] imageData = readImageAsBytes(localImagePath);
    
//     //     MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
//     //     body.add("key", apiKey);
//     //     body.add("image", new ByteArrayResource(imageData));
    
//     //     try {
//     //         return webClient.post()
//     //                 .uri("/upload")
//     //                 .contentType(MediaType.MULTIPART_FORM_DATA)
//     //                 .body(BodyInserters.fromMultipartData(body))
//     //                 .retrieve()
//     //                 .bodyToMono(ImgBBResponse.class)
//     //                 .map(ImgBBResponse::getData)
//     //                 .map(ImgBBData::getUrl)
//     //                 .block();
//     //     } catch (WebClientResponseException ex) {
//     //         String responseBody = ex.getResponseBodyAsString();
//     //         System.out.println("Erreur ImgBB - Corps de la réponse : " + responseBody);
    
//     //         // Gérez l'erreur en conséquence
//     //         return "Error uploading image. ImgBB response: " + responseBody;
//     //     } catch (Exception e) {
//     //         // Gérer d'autres exceptions
//     //         e.printStackTrace();
//     //         return "Error uploading image. Exception: " + e.getMessage();
//     //     }
//     // }
    
// }


@Service
public class ImgBBService {

    @Value("${imgbb.api-key}")
    private String apiKey;

    private final WebClient webClient;

    public ImgBBService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.imgbb.com/1").build();
    }

    public String uploadLocalImage(String localImagePath) {
        try {
            byte[] imageData = Files.readAllBytes(Paths.get(localImagePath));
            String base64Image = Base64.getEncoder().encodeToString(imageData);

            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("key", apiKey);
            body.add("image", base64Image);

            return webClient.post()
                    .uri("/upload")
                    .contentType(MediaType.MULTIPART_FORM_DATA)
                    .body(BodyInserters.fromMultipartData(body))
                    .retrieve()
                    .bodyToMono(String.class)  // Change le type de réponse en String
                    .block();
        } catch (WebClientResponseException ex) {
            String responseBody = ex.getResponseBodyAsString();
            System.out.println("Erreur ImgBB - Corps de la réponse : " + responseBody);
            return "Erreur lors du téléchargement de l'image. ImgBB response: " + responseBody;
        } catch (Exception e) {
            e.printStackTrace();
            return "Erreur lors du téléchargement de l'image. Exception: " + e.getMessage();
        }
    }



    public String uploadImages(MultipartFile localImagePath) {
        try {
            byte[] imageData = localImagePath.getBytes();
            String base64Image = Base64.getEncoder().encodeToString(imageData);

            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("key", apiKey);
            body.add("image", base64Image);

            return webClient.post()
                    .uri("/upload")
                    .contentType(MediaType.MULTIPART_FORM_DATA)
                    .body(BodyInserters.fromMultipartData(body))
                    .retrieve()
                    .bodyToMono(String.class)  // Change le type de réponse en String
                    .block();
        } catch (WebClientResponseException ex) {
            String responseBody = ex.getResponseBodyAsString();
            System.out.println("Erreur ImgBB - Corps de la réponse : " + responseBody);
            return "Erreur lors du téléchargement de l'image. ImgBB response: " + responseBody;
        } catch (Exception e) {
            e.printStackTrace();
            return "Erreur lors du téléchargement de l'image. Exception: " + e.getMessage();
        }
    }
}
