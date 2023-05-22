package org.example;

public class Arboles {
    Nodo raiz;

    public Arboles(){
        raiz = null;
    }
    public void recorridoOrden(Nodo x){
        if(x!=null){
            recorridoOrden(x.izq);
            System.out.println(x.llave);
            recorridoOrden(x.der);
        }
    }
    public void insertar(int key, Object valor){
        Nodo n = new Nodo(key);
        n.valor = valor;

        if(raiz == null){
            raiz = n;
        }else{
            Nodo tmp = raiz;
            while (tmp!=null){
                n.p = tmp;
                if(n.llave >= tmp.llave){
                    tmp = tmp.der;
                }else{
                    tmp = tmp.izq;
                }
            }
            if(n.llave < n.p.llave){
                n.p.izq = n;
            }else{
                n.p.der = n;
            }
        }
    }
    private class Nodo{
        public Nodo p;//padre
        public Nodo der;
        public Nodo izq;
        public int llave;
        public Object valor;
        public Nodo(int key){
            llave = key;
            der = null;
            izq = null;
            p = null;
            valor = null;

        }
    }

}
/* Arboles arbol = new Arboles();
        arbol.insertar(5,null);
        arbol.insertar(7,null);    <----- esto va en el main
        arbol.insertar(6,null);
        arbol.insertar(4,null);
        arbol.insertar(8,null);
        arbol.insertar(1,null);
        arbol.insertar(19,null);*/