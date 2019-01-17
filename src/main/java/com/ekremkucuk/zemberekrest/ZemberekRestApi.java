package com.ekremkucuk.zemberekrest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ekremkucuk.zemberekrest.model.AnalyzeTurkishResponse;
import zemberek.morphology.TurkishMorphology;
import zemberek.morphology.analysis.SentenceAnalysis;
import zemberek.morphology.analysis.SingleAnalysis;
import zemberek.morphology.analysis.WordAnalysis;

import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

// The Java class will be hosted at the URI path "/helloworld"
@RestController
@RequestMapping("zemberekrestapi")
public class ZemberekRestApi {

    @GetMapping("analyzeWord")
    @Produces("application/json")
    public List<AnalyzeTurkishResponse> analyzeWord(String value) {
        TurkishMorphology morphology = TurkishMorphology.createWithDefaults();
        WordAnalysis result = morphology.analyze(value);

        final List<AnalyzeTurkishResponse> responseList = new ArrayList();
        result.stream().forEach(single -> {
            AnalyzeTurkishResponse response = new AnalyzeTurkishResponse();
            response.setFormatted(single.formatLong());
            response.setLemmas(single.getLemmas());
            response.setStems(single.getStems());
            responseList.add(response);
        });

        return responseList;
    }

    @GetMapping("analyzeSentenceAndDisambiguate")
    @Produces("application/json")
    public List<AnalyzeTurkishResponse> analyzeSentenceAndDisambiguate(String sentence) {
        TurkishMorphology morphology = TurkishMorphology.createWithDefaults();

        SentenceAnalysis analysis = morphology.analyzeAndDisambiguate(sentence);

        List<SingleAnalysis> singleAnalysisList = analysis.bestAnalysis();

        final List<AnalyzeTurkishResponse> responseList = new ArrayList();
        singleAnalysisList.stream().forEach(single -> {
            AnalyzeTurkishResponse response = new AnalyzeTurkishResponse();
            response.setFormatted(single.formatLong());
            response.setLemmas(single.getLemmas());
            response.setStems(single.getStems());
            responseList.add(response);
        });

        return responseList;
    }

    @GetMapping("analyzeSentenceAndDisambiguateFull")
    @Produces("application/json")
    public List<SingleAnalysis> analyzeSentenceAndDisambiguateFull(String sentence) {
        TurkishMorphology morphology = TurkishMorphology.createWithDefaults();

        SentenceAnalysis analysis = morphology.analyzeAndDisambiguate(sentence);

        List<SingleAnalysis> singleAnalysisList = analysis.bestAnalysis();



        return singleAnalysisList;
    }
}
