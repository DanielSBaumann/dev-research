package com.devresearch.devresearch;

import com.devresearch.devresearch.dto.RespostasChart;
import com.devresearch.devresearch.repository.Pesquisas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DevResearchApplication {

    @Bean
    public CommandLineRunner init(@Autowired Pesquisas pesquisas) {
        return args -> {

            try {

                List<Object[]> list = pesquisas
                        .qtdRespostas1(1);
                List<RespostasChart> respostas = new ArrayList<>();

                list.forEach(item -> {
                    RespostasChart resp = RespostasChart
                            .builder()
                            .resposta(item[0].toString())
                            .qtdVezesRespondido(new Integer(item[1].toString()))
                            .build();
                    System.out.println(resp.toString());
                    respostas.add(resp);
                });


            } catch (Exception e) {

            }

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(DevResearchApplication.class, args);
    }

}
