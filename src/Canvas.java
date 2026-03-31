import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ArrayList;

public class Canvas extends JPanel {
    private static int SIZE = 8;
    private int x,y;
    private int canvasHeight, canvasWidth;
    private Color color;
    private List<List<ColorPoints>> allPaths;
    private List<ColorPoints> currentPath;


    public Canvas(int targetWidth, int targetHeight){

        super();
        setPreferredSize(new Dimension(targetWidth,targetHeight));
        setOpaque(true);
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        allPaths = new ArrayList<>(25);
        canvasWidth = targetWidth;
        canvasHeight = targetHeight;

        MouseAdapter ma = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                Graphics g = getGraphics();
                g.setColor(color);
                g.fillRect(x, y, SIZE, SIZE);
                g.dispose();
                currentPath = new ArrayList<>(25);
                currentPath.add(new ColorPoints(x, y, color));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                allPaths.add(currentPath);
                currentPath = null;
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                x = e.getX();
                y = e.getY();

                Graphics2D g2d = (Graphics2D) getGraphics();
                g2d.setColor(color);
                if(currentPath != null && !currentPath.isEmpty()){
                    ColorPoints prevPoint = currentPath.get(currentPath.size() - 1);
                    g2d.setStroke(new BasicStroke(SIZE));

                    g2d.drawLine(prevPoint.getX(), prevPoint.getY(), x, y);
                }
                g2d.dispose();

                ColorPoints nextPoint = new ColorPoints(e.getX(), e.getY(), color);
                currentPath.add(nextPoint);            }
        };
        addMouseListener(ma);
        addMouseMotionListener(ma);
    }

    public void setColor(Color color){
        this.color = color;
    }
    public void resetCanvas(){
        Graphics g = getGraphics();
        g.clearRect(0, 0, canvasWidth, canvasHeight);
        g.dispose();

        allPaths = new ArrayList<>(25);
        currentPath = null;
        repaint();
        revalidate();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for(List<ColorPoints> path : allPaths){
            ColorPoints from = null;
            for(ColorPoints point : path){
                g2d.setColor(point.getColor());

                if(path.size() == 1){
                    g2d.fillRect(point.getX(), point.getY(), SIZE, SIZE);
                }
                if(from != null){
                    g2d.setStroke(new BasicStroke(SIZE));
                    g2d.drawLine(from.getX(), from.getY(), point.getX(), point.getY());
                }
                from = point;
            }
        }
    }
    public void setBrushSize(int size){
        SIZE = size;
    }
}