package shubham;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.text.StyledEditorKit;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
class OpenMenu{
	public static void main(String [] args)
	{
		JFrame f=new JFrame();
		JTextPane ta=new JTextPane();
		//JRadioButton b2=new JRadioButton("red");
		//JRadioButton b1=new JRadioButton("white");
		//ButtonGroup bg=new  ButtonGroup();
		//bg.add(b1);
		//bg.add(b2);
		JScrollPane pane=new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		f.setTitle("TEXT EDITOR");
		f.setSize(600,600);
		JMenuBar m=new JMenuBar();
		JMenu file=new JMenu("file");
		JMenu edit=new JMenu("edit");
		JMenu help=new JMenu("help");
		JMenuItem cut=new JMenuItem("cut");
		JMenuItem copy=new JMenuItem("copy");
		JMenuItem paste=new JMenuItem("paste");
		JMenuItem select=new JMenuItem("select all");
		JMenuItem undo=new JMenuItem("undo");
		JMenuItem newfile=new JMenuItem("open file");
		JMenuItem savefile=new JMenuItem("save file");
		JMenuItem exit=new JMenuItem("exit");
		edit.add(cut);
		edit.add(copy);
		edit.add(select);
		edit.add(paste);
		edit.add(undo);
		file.add(newfile);
		file.add(savefile);
		file.add(exit);
		m.add(file);
		m.add(edit);
		m.add(help);
		String []s={"SansSerif","Serif"};
		String []backg={"white","red","black","pink","yellow","green"};
		String []fontc={"white","red","black","pink","yellow","green"};
		String[] fontsize={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90"};		
		JComboBox font=new JComboBox(fontsize);
		JComboBox color=new JComboBox(backg);
		JComboBox j=new JComboBox(s);
		JComboBox fontcolor=new JComboBox(fontc);
		JToolBar toolbar=new JToolBar();
		toolbar.setBounds(5,40,100,30);
		JLabel label=new JLabel("Font");
		toolbar.add(label);
		toolbar.addSeparator();
		toolbar.add(j);
		//b1.setSize(20,20);
		toolbar.addSeparator();
		JLabel label1=new JLabel("background color");
		toolbar.add(label1);
		toolbar.addSeparator();
		toolbar.add(color);
		toolbar.addSeparator();
		JLabel label2=new JLabel("font size");
		toolbar.add(label2);
		toolbar.addSeparator();
		toolbar.add(font);
		toolbar.addSeparator();
		JLabel label3=new JLabel("font color");
		toolbar.add(label3);
		toolbar.addSeparator();
		toolbar.add(fontcolor);
		for(int i=0;i<90;++i)
		{
			toolbar.addSeparator();
		}
		m.setBounds(5,5,400,40);
		ta.setBounds(5,80,400,400);
		f.setLocationRelativeTo(null);
		f.add(m);
		f.add(toolbar,BorderLayout.NORTH);
		f.setJMenuBar(m);
		//f.add(ta);
		f.add(pane);
		f.setVisible(true);
		JFileChooser choose=new JFileChooser();
		UndoManager manager = new UndoManager();
		ta.getDocument().addUndoableEditListener(manager);
		cut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ta.cut();
			}
		});
		copy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ta.copy();
			}
		});
		paste.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ta.paste();
				//Font f=new Font("Arial",1,20);
				//ta.setFont(f);
			}
		});
		select.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ta.selectAll();
			}
		});
		j.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Action serif= new StyledEditorKit.FontFamilyAction("Serif",java.awt.Font.SERIF);
				Action sans= new StyledEditorKit.FontFamilyAction("Sans",java.awt.Font.SANS_SERIF);
				if(j.getSelectedItem().toString().equals("Serif"))
				{	
					serif.actionPerformed(e);
					
				}
			}
		});
			j.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Action serif = new StyledEditorKit.FontFamilyAction("Serif", java.awt.Font.SERIF);
			    Action sans = new StyledEditorKit.FontFamilyAction("Sans", java.awt.Font.SANS_SERIF);
				if(j.getSelectedItem().toString().equals("SansSerif"))
				{	
					sans.actionPerformed(e);
				}
			}
		});
			color.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(color.getSelectedItem().equals("red"))
					{
						ta.setBackground(java.awt.Color.RED);
					}
					if(color.getSelectedItem().equals("white"))
					{
						ta.setBackground(java.awt.Color.WHITE);
					}
					if(color.getSelectedItem().equals("black"))
					{
						ta.setBackground(java.awt.Color.BLACK);
					}
					if(color.getSelectedItem().equals("yellow"))
					{
						ta.setBackground(java.awt.Color.YELLOW);
					}
					if(color.getSelectedItem().equals("green"))
					{
						ta.setBackground(java.awt.Color.GREEN);
					}
					if(color.getSelectedItem().equals("pink"))
					{
						ta.setBackground(java.awt.Color.PINK);
					}
					
				}
			});
			fontcolor.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(fontcolor.getSelectedItem().equals("red"))
					{
						ta.setForeground(java.awt.Color.RED);
					}
					if(fontcolor.getSelectedItem().equals("white"))
					{
						ta.setForeground(java.awt.Color.WHITE);
					}
					if(fontcolor.getSelectedItem().equals("black"))
					{
						ta.setForeground(java.awt.Color.BLACK);
					}
					if(fontcolor.getSelectedItem().equals("yellow"))
					{
						ta.setForeground(java.awt.Color.YELLOW);
					}
					if(fontcolor.getSelectedItem().equals("green"))
					{
						ta.setForeground(java.awt.Color.GREEN);
					}
					if(fontcolor.getSelectedItem().equals("pink"))
					{
						ta.setForeground(java.awt.Color.PINK);
					}
				} 
			});
			/*font.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				int temp=(int) font.getSelectedItem();
					System.out.println(temp);
					Font biggerFont = ta.getFont().deriveFont((float) font.getSelectedItem());
					ta.setFont(biggerFont);
				}
			});*/	
				
		undo.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					try
					{	
					manager.undo();
					}
					catch(CannotUndoException e)
					{
						e.printStackTrace();
					}
				}
			});
		newfile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int returnVal = choose.showOpenDialog(f);// to open the dilaog box for opening a file

		        if (returnVal == JFileChooser.APPROVE_OPTION)// if users selects a file
		        {
		           
		            try {
		            	 File file = choose.getSelectedFile();
		            	 FileReader r=new FileReader(file);
		            	 ta.read(r,"");
		            			 
		            	 
						 
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            
		           // System.out.println("Selected file: " + file.getAbsolutePath());
		        }
			}
		});
		savefile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int returnval=choose.showSaveDialog(f);
				if(returnval==JFileChooser.APPROVE_OPTION)
				{
					File file=choose.getSelectedFile();
					try {
						FileWriter w=new FileWriter(file);
						ta.write(w);
						w.flush();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(f,"THANK YOU");
				System.exit(0);
			}
		});
		
	}
}