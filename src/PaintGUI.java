import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;

public class PaintGUI extends JFrame {

    PaintGUI() throws Exception {
        setTitle("Paint Canvas");
        Dimension d = new Dimension();
        d.setSize(750, 600);
        setPreferredSize(d);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        ImageIcon iconImage = new ImageIcon(PaintGUI.class.getResource("/BrushIcon.png"));
        setIconImage(iconImage.getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GUIComponents();
//        play();
    }

    private void GUIComponents() {

        JPanel canvasPanel = new JPanel();
        SpringLayout springLayout = new SpringLayout();
        canvasPanel.setLayout(springLayout);
        canvasPanel.setBackground(new Color(104,127,139));

        Canvas canvas = new Canvas(734, 550);
        canvasPanel.add(canvas);
        springLayout.putConstraint(SpringLayout.NORTH, canvas, 50, SpringLayout.NORTH, canvasPanel);

        JButton colorButton = new JButton("Choose Color");
        colorButton.addActionListener(ae -> {
            Color c = JColorChooser.showDialog(null, "Pickup a Color", Color.BLACK);
            colorButton.setBackground(c);
            canvas.setColor(c);
        });
        colorButton.setFocusable(false);
        colorButton.setForeground(Color.BLACK);
        colorButton.setFont(new Font("Roboto",Font.BOLD,12));
        canvasPanel.add(colorButton);
        springLayout.putConstraint(SpringLayout.NORTH, colorButton, 10, SpringLayout.NORTH, canvasPanel);
        springLayout.putConstraint(SpringLayout.WEST, colorButton, 25, SpringLayout.WEST, canvasPanel);

        JButton reset = new JButton("Reset");
        reset.addActionListener(ae -> {
            UIManager.getLookAndFeel().provideErrorFeedback(null);
            int result = JOptionPane.showConfirmDialog(
                    null,
                    "Do You Want to Reset the Window?",
                    "Reset Window",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );
            if(result == JOptionPane.YES_OPTION){
                canvas.resetCanvas();
            }
        });
        reset.setFocusable(false);
        reset.setForeground(Color.BLACK);
        reset.setFont(new Font("Roboto",Font.BOLD,12));
        reset.setBackground(new Color(186, 104, 104));
        canvasPanel.add(reset);
        springLayout.putConstraint(SpringLayout.NORTH, reset, 10, SpringLayout.NORTH, canvasPanel);
        springLayout.putConstraint(SpringLayout.WEST, reset, 150, SpringLayout.WEST, canvasPanel);

        JButton eraserButton = new JButton("Eraser");
        eraserButton.setFocusable(false);
        eraserButton.setForeground(Color.BLACK);
        eraserButton.setFont(new Font("Roboto", Font.BOLD, 12));
        eraserButton.setBackground(new Color(200, 200, 200));
        eraserButton.addActionListener(ae -> {
            canvas.setColor(Color.WHITE);
        });
        canvasPanel.add(eraserButton);
        springLayout.putConstraint(SpringLayout.NORTH, eraserButton, 10, SpringLayout.NORTH, canvasPanel);
        springLayout.putConstraint(SpringLayout.WEST, eraserButton, 230, SpringLayout.WEST, canvasPanel);

        JSlider brushSlider = new JSlider(4, 25,8);
        brushSlider.setToolTipText("Set Size");
        brushSlider.addChangeListener(e ->
                canvas.setBrushSize(brushSlider.getValue()));
        brushSlider.setBackground(new Color(104,127,139));
        brushSlider.setOpaque(false);
        brushSlider.setPreferredSize(new Dimension(150, 20));
        canvasPanel.add(brushSlider);
        springLayout.putConstraint(SpringLayout.NORTH, brushSlider, 10, SpringLayout.NORTH, reset);
        springLayout.putConstraint(SpringLayout.WEST, brushSlider, 400, SpringLayout.WEST, reset);

        this.getContentPane().add(canvasPanel);
    }
//    public static void play() throws Exception{
//        AudioInputStream audio =
//                AudioSystem.getAudioInputStream(PaintGUI.class.getResource("/Paint Song.wav"));
//        Clip c = AudioSystem.getClip();
//        c.open(audio);
//        c.start();
//    }
}