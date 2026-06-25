public class FactoryMethodTest {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document doc1 = wordFactory.createDocument();
        doc1.open();
        
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document doc2 = pdfFactory.createDocument();
        doc2.open();
    }
}