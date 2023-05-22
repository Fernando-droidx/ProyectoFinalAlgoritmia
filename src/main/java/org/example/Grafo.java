package org.example;

import java.util.Iterator;
import java.util.LinkedList;

class Grafo {
    private int V;
    private LinkedList<Integer>[] listaAdyacencia;

    // Constructor
    Grafo(int v) {
        V = v;
        listaAdyacencia = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            listaAdyacencia[i] = new LinkedList<>();
        }
    }

    // Método para agregar una arista al grafo
    void agregarArista(int v, int w) {
        listaAdyacencia[v].add(w);
    }

    // Método para realizar el recorrido BFS y mostrar los cambios en consola
    void bfs(int inicio) {
        boolean[] visitado = new boolean[V];
        LinkedList<Integer> cola = new LinkedList<>();

        visitado[inicio] = true;
        cola.add(inicio);

        while (!cola.isEmpty()) {
            inicio = cola.poll();

            System.out.print(inicio + " -> ");

            Iterator<Integer> it = listaAdyacencia[inicio].listIterator();
            while (it.hasNext()) {
                int n = it.next();
                if (!visitado[n]) {
                    visitado[n] = true;
                    cola.add(n);
                    listaAdyacencia[inicio].removeFirst();
                    System.out.println("Cambios en el nodo " + inicio + ": " + listaAdyacencia[inicio]);
                }
            }
        }
    }

    // Método para mostrar el grafo en consola
    void mostrarGrafo() {
        for (int i = 0; i < V; ++i) {
            System.out.println("Nodo " + i + ": " + listaAdyacencia[i]);
        }
    }
}

/*Grafo grafo = new Grafo(4);

        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 2);
        grafo.agregarArista(2, 0);
        grafo.agregarArista(2, 3);
        grafo.agregarArista(3, 3);
        System.out.println("Grafo original:");       <------------------ esto va en el main
        grafo.mostrarGrafo();

        System.out.println("\nRecorrido BFS:");
        grafo.bfs(0);

        System.out.println("\nGrafo después de BFS:");
        grafo.mostrarGrafo();*/
