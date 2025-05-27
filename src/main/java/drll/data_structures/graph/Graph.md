# Data structure: Graph

##### What is a Graph?
> A graph is a tuple of a set of vertex and a set of edges between
> the vertex.

##### Notes
* This is an undirected graph
* Having `n` nodes, then, they are based on index `0` to `(n - 1)`
* This graph is implemented using an adjacency list
* This graph does not allow weight on edge, it is a very simple
implementation just for the basics and can be extended to support more 
capabilities
* **This graph is fully tested**

##### Notes
```
    // Example 1
    // How to create a graph with only 4 vertex[0, 1, 2, 3]
    
    Graph graph = new Graph(4);
```
```
    // Example 2
    // How to create a graph with only 3 edges[[0, 1],[0, 2],[0,3]]
    
    int[] edges = new int[]{{0, 1}, {0, 2}, {0, 3}};
    Graph graph = new Graph(edges);
```
```
    /*
      Functionalities provided with this graph   
    */
    
    // get total vertex count
    int vertexCount()

    // get edges count
    int edgeCount() 

    // True if exist and edge between v1 and v2, False if not
    boolean isAdjacent(int v1, int v2)

    // True if an edge between v1 and v2 is created, False in case
    // the edge already exist
    boolean addEdge(int v1, int v2) 

    // Add a list of edges
    void addEdge(int[][] edges)

    // True if an edge between v1 and v2 is removed, False in case
    // the edge is missing
    boolean removeEdge(int v1, int v2) 

    // Return all adjacents to vertex v1
    List<Integer> adjacent(int vertex) 

    // Return the count of edges related with vertex
    int vertexDegree(int vertex) 

    // Iterate over all vertex
    Iterable<Integer> vertex() 
```

## Important links
* [Grafo](https://es.wikipedia.org/wiki/Grafo)