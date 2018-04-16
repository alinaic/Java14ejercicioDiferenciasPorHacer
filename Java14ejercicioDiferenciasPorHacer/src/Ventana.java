import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ventana extends JFrame {

	// private es que el elemento solo lo puedo usar desde dentro de la clase
	// public es que lo puedo usar desde cualquier sitio

	private Image original = null;
	private Image diferencia = null;
	
	private boolean segunda_imagen = false;
	
	// null que este objeto no esta inicializado
	// un constructor es un metodo que se ejecuta
	// cuando se crea un objeto de la clase

	public Ventana() {

		// vamos a cargar las imagenes:

		try {
			original = ImageIO.read(new File("original.jpg"));
			diferencia = ImageIO.read(new File("diferencia.jpg"));
		} catch (IOException e) {
			System.out.println("no pude cargar la imagen");
			System.exit(-1);// forzar a que la aplicacion termine
		}
		// esto es un constructor que se ejecutara cuando se haga
		// un new Ventana();
		// este es un sitio ideal para preparar al objeto

		this.setSize(800, 500);
		this.setVisible(true);
		// en este caso this, seria lo mismo que
		// poner miVentana desde el principal
		this.setLocation(100, 100);
		this.setTitle("Haz click en la diferencia de la derecha");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// agrego un escuchador del raton para saber
		// donde va haciendo click el usuario

		this.addMouseListener(new MouseListener() {

			int numaciertos = 0;

			@Override
			public void mouseReleased(MouseEvent e) {
			}// suelte la tecla

			@Override
			public void mousePressed(MouseEvent e) {
			}// la pulse

			@Override
			public void mouseExited(MouseEvent e) {
			}// cuando sale el ratón

			@Override
			public void mouseEntered(MouseEvent e) {
			}// cuando el ratón ha entrado en la ventana

			@Override
			public void mouseClicked(MouseEvent e) {
				// pulsar o saltar
				
				int x = e.getX();
				int y = e.getY();
				System.out.println("click en: x: " + x + " y: " + y);
				
				if(segunda_imagen == false){
					if (x >= 554 && x <= 615 && y >= 66 && y <= 155) {

						JOptionPane.showMessageDialog(null,
								"Felicidades adivinastes una diferencia");

						numaciertos = numaciertos + 1;
						if (numaciertos == 3) {
							JOptionPane
									.showMessageDialog(null,
											"Felicidades has encontrado todas las diferencias");
							// numaciertos = 0;
						}

					} else if (x >= 669 && x <= 730 && y >= 276 && y <= 357) {

						JOptionPane.showMessageDialog(null,
								"Felicidades adivinastes la segunda diferencia");
						numaciertos++;

						if (numaciertos == 3) {
							JOptionPane
									.showMessageDialog(null,
											"Felicidades has encontrado todas las diferencias");
							// numaciertos = 0;
						}

					} else if (x >= 508 && x <= 533 && y >= 274 && y <= 295) {

						JOptionPane.showMessageDialog(null,
								"Felicidades adivinastes la tercera diferencia");
						numaciertos++;

						if (numaciertos == 3) {
							JOptionPane
									.showMessageDialog(null,
											"Felicidades has encontrado todas las diferencias");
							// numaciertos = 0;
						}

					}

					else {
						JOptionPane.showMessageDialog(null,
								"Fallastes, intentalo de nuevo");
					}
				}
				

				if (numaciertos == 3) {
					try {
						diferencia = ImageIO.read(new File("diferencia2.jpg"));
					} catch (IOException e2) {
						System.out.println("no pude cargar la segunda imagen");
						System.exit(-1);// forzar a que la aplicacion termine
					}
					
					repaint();
					
					segunda_imagen = true;

				}
				
				if(segunda_imagen == true){
					if (x >= 473 && x <= 496 && y >= 98 && y <= 130) {
						JOptionPane.showMessageDialog(null,
								"Felicidades adivinastes la GRAN diferencia");
					}
					else {
						JOptionPane.showMessageDialog(null,
								"Fallastes, intentalo de nuevo");
					}
				}
			}

		});

		// this hace referencia al objeto
		// que se creó usando el new Ventana
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		// g.setColor(Color.blue);
		// g.fillRect(50, 50, 100, 200);

		g.drawImage(original, 0, 30, 400, 400, null);
		g.drawImage(diferencia, 400, 30, 400, 400, null);

	}

}
