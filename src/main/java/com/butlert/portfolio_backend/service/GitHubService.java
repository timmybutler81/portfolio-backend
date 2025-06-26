package com.butlert.portfolio_backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class GitHubService {

    private final WebClient webClient;

    public GitHubService(WebClient webClient) {
        this.webClient = webClient;
    }

    public String fetchReadme(String githubUrl) {
        try {
            String[] parts = githubUrl.replace("https://github.com/", "")
                    .replace("http://github.com", "")
                    .split("/");
            String owner = parts[0];
            String repo = parts[1];

            String rawUrl = String.format(
                    "https://raw.githubusercontent.com/%s/%s/main/README.md",
                    owner, repo);

            Mono<String> mdMono = webClient.get()
                    .uri(rawUrl)
                    .retrieve()
                    .bodyToMono(String.class);

            return mdMono.block();

        } catch (Exception exception) {
            System.err.println("Could not fetch README for " + githubUrl + " : " + exception.getMessage());
            return null;
        }




    }

}
