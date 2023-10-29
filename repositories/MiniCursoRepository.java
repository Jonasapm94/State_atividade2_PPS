package repositories;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import models.MiniCurso;

public class MiniCursoRepository {
    private List<MiniCurso> miniCursos = new ArrayList<MiniCurso>();

    private MiniCurso chatGpt = new MiniCurso("ChatGPT em Detalhes", 100.00f, 10);
    private MiniCurso blockChain = new MiniCurso("Blockchain", 90.00f, 10);
    private MiniCurso iot = new MiniCurso("IoT", 80.00f, 10);
    private MiniCurso realidadeVirtual = new MiniCurso("Realidade Virtual", 70.00f, 10);
   
    public MiniCursoRepository(){
        miniCursos.add(chatGpt);
        miniCursos.add(blockChain);
        miniCursos.add(iot);
        miniCursos.add(realidadeVirtual);
    }

    @Override
    public String toString(){
        String cursos = "Cursos disponíveis: \n";
        for(MiniCurso curso : miniCursos){
            cursos += "Curso " + curso.getNome() + ". Preço = R$ " + curso.getPreco() + ". Vagas = " + curso.getVagas() + "\n";
        }
        return cursos;
    }

    public MiniCurso getMiniCursoByName(String name){
        List<MiniCurso> miniCursosTemp = miniCursos.stream().filter(c -> c.getNome().equals(name)).collect(Collectors.toList());
        if (miniCursosTemp.size() > 0){
            return miniCursosTemp.get(0);
        } 
        return null;
    }

    public MiniCurso getMiniCursoByIndex(int i){
        MiniCurso curso = miniCursos.get(i);
        if (curso != null){
            return curso;
        }
        return null;
    }
    
}
