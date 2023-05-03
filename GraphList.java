public class GraphList {
    
    private LinkedList<LinkedList<String[]>> vertices;

    public GraphList(String source) {
        LinkedList<String[]> l = new LinkedList<String[]>(new String[]{source,""});
        vertices = new LinkedList<LinkedList<String[]>>(l);
    }
    public void insert(String source, String edge, String dest) {
        if(vertices.head == null) {
            vertices.head = new Node<LinkedList<String[]>>(new LinkedList<String[]>(), null);
            vertices.headValue().insert(new String[]{source, ""});
            vertices.reset();
        } else if(!searchVertex(source)) {
            vertices.insert(new LinkedList<String[]>());
            vertices.currentValue().insert(new String[]{source, ""});
        } 
        vertices.currentValue().insert(new String[]{dest, edge});
        if(!searchVertex(dest)) {
            vertices.insert(new LinkedList<String[]>());
            vertices.currentValue().insert(new String[]{dest, ""});
        }
        vertices.reset();
    }
    public boolean searchVertex(String target) {
        vertices.reset();
        while(vertices.currentPos != null && vertices.currentValue().head != null) {
            if(vertices.currentValue().headValue()[0].equals(target)) {
                return true;
            }
            vertices.next();
        }
        return false;
    }
}