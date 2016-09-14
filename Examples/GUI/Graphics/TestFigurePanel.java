public class TestFigurePanel extends JFrame {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public TestFigurePanel() {
    setLayout(new GridLayout(2, 0, 5, 5));
    add(new FigurePanel(FigurePanel.LINE));
    add(new FigurePanel(FigurePanel.RECTANGLE));
    add(new FigurePanel(FigurePanel.ROUND_RECTANGLE));
    add(new FigurePanel(FigurePanel.OVAL));
    add(new FigurePanel(FigurePanel.RECTANGLE, true));
    add(new FigurePanel(FigurePanel.ROUND_RECTANGLE, true));
  }

  public static void main(String[] args) {
    TestFigurePanel frame = new TestFigurePanel();
    // frame.setSize(400, 200);
    frame.pack();
    frame.setTitle("TestFigurePanel");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}

class FigurePanel extends JPanel {
  /**
   *
   */
  private static final long serialVersionUID = 1L;
  public static final int LINE = 1;
  public static final int RECTANGLE = 2;
  public static final int ROUND_RECTANGLE = 3;
  public static final int OVAL = 4;

  private int type = 1;
  private boolean filled = false;

  public FigurePanel() {
  }

  public FigurePanel(int type) {
    this.type = type;
  }

  /**
   * Construct a FigurePanel with the specified type and filled
   */
  public FigurePanel(int type, boolean filled) {
    this.type = type;
    this.filled = filled;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Get the appropriate size for the figure
    int width = getWidth();
    int height = getHeight();

    switch (type) {
      case LINE:
        g.setColor(Color.BLACK);
        g.drawLine(10, 10, width - 10, height - 10);
        g.drawLine(width - 10, 10, 10, height - 10);
        break;
      case RECTANGLE:
        g.setColor(Color.BLUE);
        if (filled)
          g.fillRect((int) (0.1 * width), (int) (0.1 * height), (int) (0.8 * width), (int) (0.8 * height));
        else
          g.drawRect((int) (0.1 * width), (int) (0.1 * height), (int) (0.8 * width), (int) (0.8 * height));
        break;
      case ROUND_RECTANGLE:
        g.setColor(Color.RED);
        if (filled)
          g.fillRoundRect((int) (0.1 * width), (int) (0.1 * height), (int) (0.8 * width),
              (int) (0.8 * height), 20, 20);
        else
          g.drawRoundRect((int) (0.1 * width), (int) (0.1 * height), (int) (0.8 * width),
              (int) (0.8 * height), 20, 20);

        break;
      case OVAL:
        g.setColor(Color.BLACK);
        if (filled)
          g.fillOval((int) (0.1 * width), (int) (0.1 * height), (int) (0.8 * width), (int) (0.8 * height));
        else
          g.drawOval((int) (0.1 * width), (int) (0.1 * height), (int) (0.8 * width), (int) (0.8 * height));
        break;
    }
  }

  /**
   * Set a new figure type
   */
  public void setType(int type) {
    this.type = type;
    repaint();
  }

  public boolean isFilled() {
    return filled;
  }

  public void setFilled(boolean filled) {
    this.filled = filled;
  }

  public int getType() {
    return type;
  }

  @Override
  public Dimension getPreferredSize() {
    // Default Size
    return new Dimension(80, 80);
  }
}
