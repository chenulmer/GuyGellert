
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

import images.Img;
public class MapJunglePanel extends JPanel {

	private int _line;
	private int _cols;
	private int _size;
	private Img _imgBackground;
	private Img _background2;
	private Img _blockImg;
	private Img _floor;
	private  Img _snowman;
	private  Img _water;
	private Img _pyramid;
	private Img _sphinx;
	private Img _gate;
	private Img _torch;
	private Img _statu;
	private Map _map;
	public MapJunglePanel()
	{
		super();
		_line =15;
		_cols =37;
		_size = 50;

		_imgBackground = new Img("images\\Jungle\\JungleBackground.jpg", 0, 0, 1700, 900);
		_floor = new Img("images\\Jungle\\grassfloor.jpg", 0, 0, 50, 50);
		_blockImg = new Img("images\\Jungle\\Tree.png", 0, 0, 100,100 );

		try {
			try {
				AudioInputStream aip = AudioSystem.getAudioInputStream( new File("Music//JungleArea.wav"));

				Clip clip = AudioSystem.getClip();
				clip.open(aip);
				clip.start();
				clip.loop(5);
				clip.stop();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




		/**
		_background2 = new Img("images\\Jungle\\grey.jpg", 0, 315, 1000, 350);






		_snowman = new Img("images\\Moutains\\Snowman.png", 0, 0, 50, 50);

		_water = new Img("images\\Moutains\\water.jpg", 0, 0, 50, 50);
		_pyramid = new Img("images\\Moutains\\pyramid.png", 0, 0, 300, 300);
		_sphinx = new Img("images\\Moutains\\sphinx.png", 0, 0, 200, 200);
		_gate = new Img("images\\Moutains\\gate.png", 0, 0, 100, 100);
		_torch = new Img("images\\Moutains\\torch.png", 0, 0, 200, 200);
		_statu = new Img("images\\Moutains\\statu.png", 0, 0, 100, 100);
		 **/
		_map = new Map(_line, _cols, "map\\Jungle\\file1.xml");


		_map.get_map();
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		_imgBackground.drawImg(g);
		//_background2.drawImg(g);
		for (int i=0; i< _line; i++)
		{
			for(int j=0; j<_cols; j++)
			{
				if (_map.get_map()[i][j]  == 1) // BrownBlock
				{
					_blockImg.setImgCords((j * _size), (i) * _size);
					_blockImg.drawImg(g);
				}
				else if(_map.get_map()[i][j]  == 2)
				{
					_floor.setImgCords((j * _size), (i) * _size);
					_floor.drawImg(g);
				}
				else if(_map.get_map()[i][j]  == 3)
				{
					_snowman.setImgCords((j * _size), (i) * _size);
					_snowman.drawImg(g);
				}
				else if(_map.get_map()[i][j]  == 4)
				{
					_water.setImgCords((j * _size), (i) * _size);
					_water.drawImg(g);
				}
				else if(_map.get_map()[i][j]  == 5)
				{
					_pyramid.setImgCords((j * _size), (i) * _size);
					_pyramid.drawImg(g);
				}
				else if(_map.get_map()[i][j]  == 6)
				{
					_sphinx.setImgCords((j * _size), (i) * _size);
					_sphinx.drawImg(g);
				}
				else if(_map.get_map()[i][j]  == 7)
				{
					_gate.setImgCords((j * _size), (i) * _size);
					_gate.drawImg(g);
				}
				else if(_map.get_map()[i][j]  == 8)
				{
					_torch.setImgCords((j * _size), (i) * _size);
					_torch.drawImg(g);
				}
				else if(_map.get_map()[i][j]  == 9)
				{
					_statu.setImgCords((j * _size), (i) * _size);
					_statu.drawImg(g);
				}
			}
		}
	}


}
