/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.prova.teste;

import br.com.prova.entity.TbJogo;
import br.com.prova.facade.JogoWSClientFacade;
import java.util.List;

/**
 *
 * @author xSandman
 */
public class JogoWSClientFacadeTest {

    private final static JogoWSClientFacade JRC = new JogoWSClientFacade();

    public static void main(String[] args) {
//        
//        findByIdTest("4");
//        findByPartTituloTest("Elden");
//        createTest();
//        editTest();
//        removeTest("2");
//        listAllTest();
    }

    private static void listAllTest() {
        List<TbJogo> list = JRC.listAll();
        if (!list.isEmpty()) {
            System.out.println("Lista de registros encontrados....");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getIdJogo() + " - " + list.get(i).getTitulo());
            }
            System.out.println("-----------------------------------");
        } else {
            System.out.println("Nenhum registro encontrado...");
        }
    }

    private static TbJogo findByIdTest(String id) {
        TbJogo jogo = JRC.findById(id);
        if (jogo != null) {
            System.out.println("Registro localizado com sucesso!");
        } else {
            System.out.println("Não foi localizado nenhum registro com id: " + id);
        }
        System.out.println("---------------------------------------");
        return jogo;
    }

    private static void findByPartTituloTest(String titulo) {
        List<TbJogo> list = JRC.findByPartTitulo(titulo);
        if (!list.isEmpty()) {
            System.out.println("Registros localizados...");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getIdJogo() + " - " + list.get(i).getTitulo());
            }
            System.out.println("------------------------------------");
        } else {
            System.out.println("Nenhum registro localizado.");
        }
    }

    private static void createTest() {
        TbJogo entity = new TbJogo();
        entity.setTitulo("Metal Gear Solid");
        entity.setGenero("FPS");
        JRC.create(entity);
        System.out.println("Registro criado com sucesso!");
        System.out.println("------------------------------------------");
    }

    private static void editTest() {
        String id = "1";
        if (findByIdTest(id) != null) {
            TbJogo entity = JRC.findById(id);
            entity.setTitulo("Castlevania");
            entity.setGenero("TERROR");
            JRC.edit(entity);
            System.out.println("Registro alterado com sucesso!");
            System.out.println("-----------------------------------");
        }
    }

    private static void removeTest(String id) {
        String idRemoved = id;
        if (findByIdTest(id) != null) {
            JRC.remove(id);
            System.out.println("Registro removido com sucesso, ID: " + idRemoved);
            System.out.println("-------------------------------------------");
        }
    }
}
