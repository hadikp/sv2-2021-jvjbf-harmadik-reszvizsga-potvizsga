package examinformation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ExamService {

    private double practiceMax;
    private double theoryMax;

    private Map<String, ExamResult> results = new TreeMap<>();

    public double getPracticeMax() {
        return practiceMax;
    }

    public double getTheoryMax() {
        return theoryMax;
    }

    public Map<String, ExamResult> getResults() {
        return results;
    }

    public void readFromFIle(Path path) {

        try {
            List<String> examresult = Files.readAllLines(path);
            theoryMax = Integer.parseInt(examresult.get(0).split(" ")[0]);
            practiceMax = Integer.parseInt(examresult.get(0).split(" ")[1]);
            for (int i = 1; i < examresult.size(); i++) {
                String name = examresult.get(i).split(";")[0];
                String points = examresult.get(i).split(";")[1];
                int theory = Integer.parseInt(points.split(" ")[0]);
                int practice = Integer.parseInt(points.split(" ")[1]);
                results.put(name, new ExamResult(theory, practice));
            }

        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file: " + ioe.getMessage());
        }
    }

    public List<String> findPeopleFailed(){
        List<String> result = new ArrayList<>();
        for(Map.Entry<String, ExamResult> entries: results.entrySet()){
            if((entries.getValue().getTheory() / theoryMax) * 100<51 || (entries.getValue().getPractice()/practiceMax) * 100<51){
                result.add(entries.getKey());
            };
        }
        return result;
    }

    public String findBestPerson(){
        Map<String, Integer> allPoints = new TreeMap<>();
        String result = "";
        double points = 0;
        for(Map.Entry<String, ExamResult> entries: results.entrySet()){
            if((entries.getValue().getTheory() / theoryMax) * 100>51 && (entries.getValue().getPractice() / practiceMax) * 100>51) {
                allPoints.put(entries.getKey(), (entries.getValue().getTheory() + entries.getValue().getPractice()));
            }
        }
        for(Map.Entry<String, Integer> entries: allPoints.entrySet()){
            if(entries.getValue() > points){
                points = entries.getValue();
            }
        }
        for(Map.Entry<String,Integer> entries: allPoints.entrySet()){
            if(entries.getValue() == points) {
                result=entries.getKey();
            }
        }
        return result;
    }
}
