package rep1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class GraphicsPanel extends JPanel implements MouseListener, MouseMotionListener{

	private GoL gl;
	private short[][] matrix;
	private Rectangle[][] grid;

	private int mouseX, mouseY;


	public GraphicsPanel(GoL gol) {
		this.gl = gol;
		this.matrix = gol.getMatrix();
		this.grid = new Rectangle[gl.getSize()][gl.getSize()];

		int length = 400/gl.getSize();
		for(int i=0;i<gl.getSize();i++) {
			for(int j=0;j<gl.getSize();j++) {
				grid[i][j] = new Rectangle(length*i, length*j, length, length);
			}
		}

		addMouseMotionListener(this);
		addMouseListener(this);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		for(int i=0;i<gl.getSize();i++){
			for(int j=0;j<gl.getSize();j++){
				if(matrix[i][j]==1) {
					g2.setColor(Color.WHITE);
				}else {
					g2.setColor(Color.BLACK);
				}
				g2.fill(grid[i][j]);
			}

		}
		g2.setColor(Color.RED);
		g2.draw(grid[mouseX][mouseY]);

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(grid[i][j].contains(e.getPoint())) {
					mouseX = i;
					mouseY = j;
					repaint();
					return;
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("clicked");
		gl.cellClicked(mouseX, mouseY);
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
