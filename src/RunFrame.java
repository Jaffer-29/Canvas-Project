import javax.swing.*;

public class RunFrame {
    public static void main(String[] arg){

        SwingUtilities.invokeLater(()->{
            try {
                new PaintGUI().setVisible(true);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

    }
}