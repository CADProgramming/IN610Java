package pcrashstatistics;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class DataForm extends JFrame implements ItemListener, ActionListener, ChangeListener {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Array of all the column headers to add to Choice boxes
	 */
	private String[] columnHeaders =  {
			"Row ID", "Year", "Severity", "Fatalities", "Serious Injuries", "Minor Injuries", "Vehicles Involved", "Location", "At Intersection", "Junction Type", "From Side Road", 
			"Crash Distance", "On State Highway", "Terrain Level", "Road Character", "Road Curvature", "Road Markings", "Road Surface", "Road Is Wet", "Traffic Control", 
			"Speed Limit", "Advised Limit", "Temporary Limit", "Light", "Weather A", "Weather B", "Animals Hit", "Bridges Hit", "Cliffs or Banks Hit", "Debris Hit", 
			"Ditches Hit", "Fences Hit", "Guard Rails Hit", "Houses or Buildings Hit", "Kerbs Hit", "Thrown or Dropped Objects Hit", "Others Hit", "Overbanks Hit", "Parked Vehicles Hit", 
			"Phone Boxes Etc Hit", "Posts or Poles Hit", "Roadworks Hit", "Slips or Floods Hit", "Stray Animals Hit", "Traffic Islands Hit", "Traffic Signs Hit", "Trains Hit", 
			"Trees Hit", "Vehicles Hit", "Water or Rivers Hit", "Bicycles Involved", "Buses Involved", "Car or Station Wagons Involved", "Mopeds Involved", "Motorcycles Involved", 
			"Other Vehicles Involved", "School Buses Involved", "SUVs Involved", "Taxis Involved", "Trucks Involved", "Unknown Vehicle Involved", "Vans or Utes Involved", 
			"Pedestrians Involved"
			};
	/**
	 * Array of String choices to check if the user has selected a String option
	 */
	private String[] stringSearchTerms = { 
			"Severity", "Vehicles Involved", "Location", "Junction Type", "Terrain Level", "Road Character", "Road Curvature", "Road Markings", "Road Surface", "Traffic Control", 
			"Light", "Weather A", "Weather B"
	};
	/**
	 * Array of boolean choices to check if the user has selected a boolean option
	 */
	private String[] boolSearchTerms = {
			"At Intersection", "From Side Road", "On State Highway", "Road Is Wet"	
	};

	
	/**
	 * Store information related to the item viewer tab
	 */
	private int itemViewerIndex;
	private int itemViewerListSize;
	
	
	/**
	 * All the array lists the form needs access
	 */
	private ArrayList<VehicleCrash> crashData;
	private ArrayList<VehicleCrash> searchData;
	private ArrayList<VehicleCrash> topTen;
	private ArrayList<VehicleCrash> bottomTen;
	
	
	/**
	 * The main UI containers
	 */
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	
	
	/**
	 * Sort tab components
	 */
	private JPanel sortPanel;
	private JScrollPane scrollPane;
	private JTable sortingTable;
	private DefaultTableModel sortingTableModel;
	private JPanel sortSelection;
	private JPanel labelPanel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPanel choicePanel;
	private Choice categoryChoice;
	private Choice directionChoice;
	private JButton sortButton;
	private JLabel sortLabel;
	private JPanel infoSortSidePanel;
	private JTextPane textPane;
	private JLabel imageheader;
	
	
	/**
	 * Item Viewer tab components
	 */
	private JPanel itemViewPanel;
	private JPanel itemViewContainer;
	private JPanel textAreaPanel;
	private JTextPane itemView;
	private JPanel btnControlPanel;
	private JPanel leftButtons;
	private JButton firstButton;
	private JButton previousButton;
	private JPanel checkBoxes;
	private JCheckBox viewSearchData;
	private JPanel rightButtons;
	private JButton nextButton;
	private JButton lastButton;
	private JPanel infoPanel;
	private JLabel itemViewIndexLabel;
	
	
	/**
	 * Search tab components
	 */
	private JPanel searchPanel;
	private JScrollPane scrollPane_1;
	private JTable searchTable;
	private DefaultTableModel searchTableModel;
	private JPanel searchFields;
	private JScrollPane filterScrollPane;
	private JPanel filterContainerPanel;
	private JLabel lblNewLabel_2;
	private JPanel buttonControlPanel;
	private JButton addButton;
	private JButton applyButton;
	private JLabel gapLabel;
	private JLabel searchResultLabel;
	
	
	/**
	 * Statistics tab components
	 */
	private JPanel statsPanel;
	private JPanel controlPanel1;
	private Choice statsCategory;
	private Checkbox statsCheckBox;
	private JPanel dataPanel;
	private JTextPane statsTextPane1;
	private JPanel top10Panel;
	private JScrollPane scrollPane_2;
	private JTable topTenTable;
	private DefaultTableModel topTenTableModel;
	private JPanel bottom10Panel;
	private JScrollPane scrollPane_3;
	private JTable bottomTenTable;
	private DefaultTableModel bottomTenTableModel;
	private JPanel displayPanel;
	private JScrollPane scrollPane_4;
	private JTextPane statsTextPane2;
	private JPanel controlPanel2;
	private JLabel lblNewLabel_3;
	private Choice topBottomChoice;
	private JLabel lblOfValue;
	private JSpinner topBottomNumSpinner;
	
	/**
	 * Creation of the UI JFrame that contains the application UI
	 * @param crashData Imported data from CSV in VehicleCrash object format
	 * @throws IllegalAccessException Unauthorized access
	 * @throws IllegalArgumentException Argument is invalid
	 * @throws InvocationTargetException Target not found
	 */
	public DataForm(ArrayList<VehicleCrash> crashData) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		//Makes the frame start center screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle formSize = new Rectangle(0, 0, 1400, 900);
		Rectangle formPosition = new Rectangle(
				(screenSize.width / 2) - (formSize.width / 2), 
				(screenSize.height / 2) - (formSize.height / 2),
				formSize.width,
				formSize.height);
		
		setBounds(formPosition);
		setVisible(true);
		setResizable(false);
		setTitle("Crash Statistics NZ (2000 - 2018)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		itemViewerIndex = 0;
		itemViewerListSize = 0;
		
		this.crashData = crashData;
		
		searchData = new ArrayList<VehicleCrash>();
		topTen = new ArrayList<VehicleCrash>();
		bottomTen = new ArrayList<VehicleCrash>();
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setPreferredSize(new Dimension(800, 762));
		tabbedPane.setSize(new Dimension(800, 800));
		contentPane.add(tabbedPane);
		
		//Sets up all UI
		setupSortTab();
		setupItemViewTab();
		setupSearchTab();
		setupStatisticsTab();
		
		//Refreshes UI
		repaint();
		
		//Adds data to components
		updateItemViewer();
		updateStatsTab();
		drawTableData(crashData, sortingTable, sortingTableModel);
		drawTableData(crashData, searchTable, searchTableModel);
	}
	
	/**
	 * Creates and sets up all UI for the sort tab
	 */
	private void setupSortTab() {
		
		sortingTableModel = new DefaultTableModel(new Object[][] {}, columnHeaders);
		
		sortPanel = new JPanel();
		tabbedPane.addTab("Sort Data", null, sortPanel, null);
		sortPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setLocation(new Point(100, 100));
		scrollPane.setBounds(10, 11, 900, 802);
		scrollPane.setPreferredSize(new Dimension(800, 728));
		scrollPane.setMinimumSize(new Dimension(800, 760));
		sortPanel.add(scrollPane);
		
		sortingTable = new JTable();
		sortingTable.setRowSelectionAllowed(false);
		sortingTable.setEnabled(false);
		sortingTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		sortingTable.setModel(sortingTableModel);
		scrollPane.setViewportView(sortingTable);
		
		sortSelection = new JPanel();
		sortSelection.setBounds(new Rectangle(920, 11, 449, 811));
		sortSelection.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Sort", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		sortSelection.setBounds(920, 538, 449, 284);
		sortPanel.add(sortSelection);
		sortSelection.setLayout(null);
		
		labelPanel = new JPanel();
		labelPanel.setBounds(10, 76, 429, 24);
		sortSelection.add(labelPanel);
		labelPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Category");
		lblNewLabel.setBounds(97, 0, 65, 24);
		labelPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Direction");
		lblNewLabel_1.setBounds(315, 0, 77, 24);
		labelPanel.add(lblNewLabel_1);
		
		choicePanel = new JPanel();
		choicePanel.setBounds(10, 100, 429, 30);
		sortSelection.add(choicePanel);
		
		categoryChoice = new Choice();
		categoryChoice.setBounds(30, 6, 197, 20);
		categoryChoice.setMaximumSize(new Dimension(100, 32767));
		categoryChoice.addItemListener(this);
		for (String type : columnHeaders) {
			categoryChoice.add(type);
		}
		choicePanel.setLayout(null);
		choicePanel.add(categoryChoice);
		
		directionChoice = new Choice();
		directionChoice.setBounds(287, 6, 112, 20);
		directionChoice.add("Ascending");
		directionChoice.add("Descending");
		directionChoice.addItemListener(this);
		choicePanel.add(directionChoice);
		
		sortButton = new JButton("Sort");
		sortButton.setBounds(104, 222, 241, 24);
		sortButton.addActionListener(this);
		sortSelection.add(sortButton);
		
		sortLabel = new JLabel("Sort by Row ID Ascending: ");
		sortLabel.setBounds(39, 166, 371, 14);
		sortSelection.add(sortLabel);
		
		infoSortSidePanel = new JPanel();
		infoSortSidePanel.setBounds(new Rectangle(920, 11, 449, 811));
		infoSortSidePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Car Crash Statistics NZ (2000 - 2018)", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		infoSortSidePanel.setBounds(920, 11, 449, 516);
		sortPanel.add(infoSortSidePanel);
		infoSortSidePanel.setLayout(null);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPane.setBounds(14, 218, 420, 287);
		textPane.setText("About the data\r\n" + 
				"The crash data provides information about each individual traffic crash reported to the Transport Agency by the NZ Police since 1 January 2000.\r\n" + 
				"\r\n" + 
				"Crash data source\r\n" + 
				"The data was extracted from the Transport Agency Crash Analysis System (CAS). CAS records all traffic crashes as reported to the Transport Agency by the NZ Police. Not all crashes are reported to the NZ Police and the level of reporting increases with the severity of the crash. Due to the nature of non-fatal crashes it is believed that these are under-reported.\r\n" + 
				"\r\n" + 
				"CAS covers crashes on all New Zealand roadways or places where the public have legal access with a motor vehicle.\r\n"
				+ "https://www.nzta.govt.nz/safety/safety-resources/road-safety-info\nrmation-and-tools/disaggregated-crash-data/");
		infoSortSidePanel.add(textPane);
		
		imageheader = new JLabel("");
		imageheader.setBounds(14, 20, 420, 187);
		ImageIcon image = new ImageIcon("Header.jpg");
		imageheader.setIcon(image);
		infoSortSidePanel.add(imageheader);
	}
	
	/**
	 * Creates and sets up all UI for the Item Viewer tab
	 */
	private void setupItemViewTab() {
		
		itemViewPanel = new JPanel();
		tabbedPane.addTab("Item View", null, itemViewPanel, null);
		itemViewPanel.setLayout(null);
		
		itemViewContainer = new JPanel();
		itemViewContainer.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Item Viewer", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		itemViewContainer.setBounds(10, 11, 1349, 801);
		itemViewPanel.add(itemViewContainer);
		itemViewContainer.setLayout(new BoxLayout(itemViewContainer, BoxLayout.Y_AXIS));
		
		textAreaPanel = new JPanel();
		FlowLayout fl_textAreaPanel = (FlowLayout) textAreaPanel.getLayout();
		fl_textAreaPanel.setVgap(25);
		textAreaPanel.setMaximumSize(new Dimension(500, 550));
		itemViewContainer.add(textAreaPanel);
		
		itemView = new JTextPane();
		itemView.setFont(new Font("Tahoma", Font.PLAIN, 15));
		itemView.setPreferredSize(new Dimension(500, 500));
		itemView.setMinimumSize(new Dimension(500, 500));
		textAreaPanel.add(itemView);
		
		btnControlPanel = new JPanel();
		btnControlPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnControlPanel.setMaximumSize(new Dimension(500, 50));
		itemViewContainer.add(btnControlPanel);
		btnControlPanel.setLayout(new BoxLayout(btnControlPanel, BoxLayout.X_AXIS));
		
		leftButtons = new JPanel();
		leftButtons.setMaximumSize(new Dimension(300, 500));
		btnControlPanel.add(leftButtons);
		
		firstButton = new JButton("<< First");
		leftButtons.add(firstButton);
		firstButton.addActionListener(this);
		
		previousButton = new JButton("< Previous");
		leftButtons.add(previousButton);
		previousButton.addActionListener(this);
		
		checkBoxes = new JPanel();
		checkBoxes.setMaximumSize(new Dimension(75, 500));
		btnControlPanel.add(checkBoxes);
		
		viewSearchData = new JCheckBox("Use search data");
		checkBoxes.add(viewSearchData);
		viewSearchData.addItemListener(this);
		
		rightButtons = new JPanel();
		rightButtons.setMaximumSize(new Dimension(300, 500));
		btnControlPanel.add(rightButtons);
		
		nextButton = new JButton("Next >");
		rightButtons.add(nextButton);
		nextButton.addActionListener(this);
		
		lastButton = new JButton("Last >>");
		rightButtons.add(lastButton);
		
		infoPanel = new JPanel();
		infoPanel.setMaximumSize(new Dimension(500, 32767));
		itemViewContainer.add(infoPanel);
		infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 75));
		
		itemViewIndexLabel = new JLabel("label");
		itemViewIndexLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		infoPanel.add(itemViewIndexLabel);
		lastButton.addActionListener(this);
	}
	
	/**
	 * Creates and sets up all UI for the Search tab
	 */
	private void setupSearchTab() {
		
		searchTableModel = new DefaultTableModel(new Object[][] {}, columnHeaders);
		
		searchPanel = new JPanel();
		tabbedPane.addTab("Search Data", null, searchPanel, null);
		searchPanel.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setPreferredSize(new Dimension(800, 728));
		scrollPane_1.setMinimumSize(new Dimension(800, 760));
		scrollPane_1.setLocation(new Point(100, 100));
		scrollPane_1.setBounds(469, 11, 900, 802);
		searchPanel.add(scrollPane_1);
		
		searchTable = new JTable();
		searchTable.setRowSelectionAllowed(false);
		searchTable.setEnabled(false);
		searchTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		searchTable.setModel(searchTableModel);	
		scrollPane_1.setViewportView(searchTable);
		
		searchFields = new JPanel();
		searchFields.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search Fields", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		searchFields.setBounds(10, 11, 449, 811);
		searchPanel.add(searchFields);
		searchFields.setLayout(null);
		
		filterScrollPane = new JScrollPane();
		filterScrollPane.setWheelScrollingEnabled(false);
		filterScrollPane.setBounds(10, 16, 429, 779);
		searchFields.add(filterScrollPane);
		
		filterContainerPanel = new JPanel();
		filterContainerPanel.setName("");
		filterScrollPane.setViewportView(filterContainerPanel);
		filterContainerPanel.setLayout(new BoxLayout(filterContainerPanel, BoxLayout.Y_AXIS));
		
		lblNewLabel_2 = new JLabel("Click Add Filter to add a new search filter");
		lblNewLabel_2.setMaximumSize(new Dimension(250, 32));
		lblNewLabel_2.setMinimumSize(new Dimension(196, 32));
		lblNewLabel_2.setPreferredSize(new Dimension(196, 32));
		lblNewLabel_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		filterContainerPanel.add(lblNewLabel_2);
		
		buttonControlPanel = new JPanel();
		buttonControlPanel.setName("buttonControlPanel");
		filterContainerPanel.add(buttonControlPanel);
		buttonControlPanel.setLayout(new BoxLayout(buttonControlPanel, BoxLayout.X_AXIS));
		
		addButton = new JButton("Add Filter");
		buttonControlPanel.add(addButton);
		addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		addButton.addActionListener(this);
		
		applyButton = new JButton("Apply Filters");
		applyButton.setEnabled(false);
		buttonControlPanel.add(applyButton);
		applyButton.addActionListener(this);

		searchResultLabel = new JLabel();
		searchResultLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		searchResultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		searchResultLabel.setVisible(false);
		searchResultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gapLabel = new JLabel(" ");
		filterContainerPanel.add(gapLabel);
		filterContainerPanel.add(searchResultLabel);
	}
	
	/**
	 * Creates and sets up all UI for the Statistics tab
	 */
	private void setupStatisticsTab() {
		
		topTenTableModel = new DefaultTableModel(new Object[][] {}, columnHeaders);
		bottomTenTableModel = new DefaultTableModel(new Object[][] {}, columnHeaders);
		
		statsPanel = new JPanel();
		tabbedPane.addTab("Data Statistics", null, statsPanel, null);
		statsPanel.setLayout(null);
		
		controlPanel1 = new JPanel();
		controlPanel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		controlPanel1.setBounds(10, 11, 344, 46);
		statsPanel.add(controlPanel1);
		
		statsCategory = new Choice();
		statsCategory.addItemListener(this);
		
		for (String category : columnHeaders) {
			
			statsCategory.add(category);
		}
		
		controlPanel1.add(statsCategory);
		
		statsCheckBox = new Checkbox("Use Search Data");
		statsCheckBox.addItemListener(this);
		controlPanel1.add(statsCheckBox);
		
		dataPanel = new JPanel();
		dataPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		dataPanel.setBounds(10, 68, 344, 282);
		statsPanel.add(dataPanel);
		
		statsTextPane1 = new JTextPane();
		statsTextPane1.setEditable(false);
		statsTextPane1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		statsTextPane1.setPreferredSize(new Dimension(320, 265));
		statsTextPane1.setMinimumSize(new Dimension(6, 7));
		dataPanel.add(statsTextPane1);
		
		top10Panel = new JPanel();
		top10Panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Top 10 Results", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		top10Panel.setBounds(363, 361, 1006, 228);
		statsPanel.add(top10Panel);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setPreferredSize(new Dimension(994, 200));
		scrollPane_2.setMinimumSize(new Dimension(800, 760));
		scrollPane_2.setLocation(new Point(100, 100));
		top10Panel.add(scrollPane_2);
		
		topTenTable = new JTable();
		topTenTable.setRowSelectionAllowed(false);
		topTenTable.setEnabled(false);
		topTenTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		topTenTable.setModel(topTenTableModel);
		scrollPane_2.setViewportView(topTenTable);
		
		bottom10Panel = new JPanel();
		bottom10Panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Bottom 10 Results", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		bottom10Panel.setBounds(362, 600, 1006, 222);
		statsPanel.add(bottom10Panel);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setPreferredSize(new Dimension(994, 200));
		scrollPane_3.setMinimumSize(new Dimension(800, 760));
		scrollPane_3.setLocation(new Point(100, 100));
		bottom10Panel.add(scrollPane_3);
		
		bottomTenTable = new JTable();
		bottomTenTable.setRowSelectionAllowed(false);
		bottomTenTable.setEnabled(false);
		bottomTenTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		bottomTenTable.setModel(bottomTenTableModel);
		scrollPane_3.setViewportView(bottomTenTable);
		
		displayPanel = new JPanel();
		displayPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		displayPanel.setBounds(10, 418, 344, 404);
		statsPanel.add(displayPanel);
		
		scrollPane_4 = new JScrollPane();
		scrollPane_4.setPreferredSize(new Dimension(320, 387));
		scrollPane_4.setSize(new Dimension(320, 387));
		scrollPane_4.setMaximumSize(new Dimension(320, 387));
		displayPanel.add(scrollPane_4);
		
		statsTextPane2 = new JTextPane();
		statsTextPane2.setMaximumSize(new Dimension(320, 387));
		scrollPane_4.setViewportView(statsTextPane2);
		statsTextPane2.setEditable(false);
		statsTextPane2.setPreferredSize(new Dimension(320, 387));
		
		controlPanel2 = new JPanel();
		controlPanel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		controlPanel2.setBounds(10, 361, 344, 46);
		statsPanel.add(controlPanel2);
		
		lblNewLabel_3 = new JLabel("Show ");
		controlPanel2.add(lblNewLabel_3);
		
		topBottomChoice = new Choice();
		topBottomChoice.addItemListener(this);
		topBottomChoice.add("Top 10 Table Data");
		topBottomChoice.add("Bottom 10 Table Data");
		controlPanel2.add(topBottomChoice);
		
		lblOfValue = new JLabel(" at value: ");
		controlPanel2.add(lblOfValue);
		
		topBottomNumSpinner = new JSpinner();
		topBottomNumSpinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		topBottomNumSpinner.addChangeListener(this);
		controlPanel2.add(topBottomNumSpinner);
	}
	
	/**
	 * Resizes all of the columns in a table to fit the longest cell data
	 * @param table The table to resize columns
	 */
	private void calculateColumnSizes(JTable table) {
		
		for (int column = 0; column < table.getColumnCount(); column++) {
			
		    TableColumn tableColumn = table.getColumnModel().getColumn(column);
		    int colWidth = tableColumn.getHeaderValue().toString().length(); //Sets initial width to the column header width
		    
		    for (int row = 0; row < table.getRowCount(); row++) {
		    	
		    	Object value = table.getValueAt(row, column);
		    	String stringVal = "";
		    	
		    	if (value != null) stringVal = value.toString();
		    	
		    	int stringLen = 0;
		    	
		    	if (stringVal != null) stringLen = stringVal.length();
		    	
		    	if (stringLen > colWidth) { //If the row data is longer than the header - resize column
		    		
		    		colWidth = stringLen;
		    	}
		    }
		    
		    tableColumn.setPreferredWidth( 10 + colWidth * 6 ); //Set column width
		}
	}
	
	/**
	 * Draws all of the VehicleCrash object values to the specified table
	 * @param data The list of crashes to be displayed
	 * @param table The table to display the crashes on
	 * @param tableModel The table layout
	 */
	public void drawTableData(ArrayList<VehicleCrash> data, JTable table, DefaultTableModel tableModel) {
		applyButton.setEnabled(false);
		calculateColumnSizes(table);
		
		tableModel.setRowCount(0);
		for (int r = 0; r < data.size(); r++) {
			
			Object[] object = new Object[64];
			
			VehicleCrash crash = data.get(r);
			
			object[0] = crash.getRowID();
			object[1] = crash.getYear();
			object[2] = crash.getSeverity();
			
			int[] injuries = crash.getInjuries();
			object[3] = injuries[0];
			object[4] = injuries[1];
			object[5] = injuries[2];
			
			object[6] = crash.getVehiclesInvolved();
			object[7] = crash.getLocation();
			object[8] = crash.isIntersection();
			object[9] = crash.getJunctionType();
			object[10] = crash.isFromSideRoad();
			
			
			object[11] = crash.getCrashDistance();
			object[12] = crash.isOnStateHighway();
			object[13] = crash.getTerrainLevel();
			object[14] = crash.getRoadCharacter();
			object[15] = crash.getRoadCurvature();
			object[16] = crash.getRoadMarking();
			object[17] = crash.getRoadSurface();
			object[18] = crash.isRoadIsWet();
			object[19] = crash.getTrafficControl();
			
			
			int[] speedLimits = crash.getSpeedLimits();
			object[20] = speedLimits[0];
			object[21] = speedLimits[1];
			object[22] = speedLimits[2];
			
			object[23] = crash.getLightConditions();
			object[24] = crash.getWeatherA();
			object[25] = crash.getWeatherB();

			int[] objectCollisions = crash.getCrashObjectsHit();
			for	(int i = 0; i < 37; i++) {
				
				object[26 + i] = objectCollisions[i];
			}
			
			tableModel.addRow(object);	
		}
		
		calculateColumnSizes(table);
		applyButton.setEnabled(true);
	}

	/**
	 * Event method for the ItemEvent
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {

		//Update sort label with sort options
		if (e.getSource().equals(categoryChoice) || e.getSource().equals(directionChoice)) {
			
			if (sortLabel != null) sortLabel.setText("Sort by " + categoryChoice.getSelectedItem() + " " + directionChoice.getSelectedItem());
		}
		
		//Update statistics tab when option changed
		if (e.getSource().equals(statsCategory) || 
				e.getSource().equals(statsCheckBox)) {
			
			updateStatsTab();
		}
		
		//Update top or bottom 10 displayed statistic
		if (e.getSource().equals(topBottomChoice)) {
			
			updateStatsBox();
		}
		
		//Update the item viewer to use or not use search data
		if (e.getSource().equals(viewSearchData)) {
			itemViewerIndex = 0;
			updateItemViewer();
		}
	}

	/**
	 * Event method for the ActionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		//Sort the table on button press
		if (e.getSource().equals(sortButton)) {
			
			sortTable();
		}
		
		//Add a search filter UI to filter panel
		if (e.getSource().equals(addButton)) {
			
			addSearchFilter();
		}
		
		//Apply all search filters to data set
		if (e.getSource().equals(applyButton)) {
			
			System.out.println("Searching using filters...");
			
			//Gets the results
			ArrayList<String> filters = getSearchFilters();
			searchData = DataSearcher.searchWithFilters(crashData, filters);
			
			System.out.println("Search finished... Updating table");
			
			//Updates table with results
			drawTableData(searchData, searchTable, searchTableModel);
			
			System.out.println("Successfully updated table\n");
			
			//If results are found
			if (filters.size() > 0) {
				
				//Display amount of results
				if (searchData.size() == 1) {
					
					searchResultLabel.setText("Search found " + searchData.size() + " result");
				}
				else {
					
					searchResultLabel.setText("Search found " + searchData.size() + " results");
				}
				
				searchResultLabel.setVisible(true);
			}
			else {
				
				searchResultLabel.setVisible(false);
			}
		}
		
		//Go to first result in the item viewer
		if (e.getSource().equals(firstButton)) {
					
			itemViewerIndex = 0;
			updateItemViewer();
		}
		
		//Go to the previous result in the item viewer
		if (e.getSource().equals(previousButton)) {
			
			itemViewerIndex--;
			updateItemViewer();
		}
		
		//Go to the next result in the item viewer
		if (e.getSource().equals(nextButton)) {
			
			itemViewerIndex++;
			updateItemViewer();
		}
		
		//Go to the last result in the item viewer
		if (e.getSource().equals(lastButton)) {
			
			itemViewerIndex = itemViewerListSize - 1;
			updateItemViewer();
		}
	}
	
	/**
	 * Update the item viewer using normal or search data
	 */
	private void updateItemViewer() {
		
		//Use search data
		if (viewSearchData.isSelected() &&
				searchData.size() > 0) {
			
			itemViewerListSize = searchData.size();
;			drawItemViewer(searchData);
		}
		//Use normal data
		else {
			
			itemViewerListSize = crashData.size();
			drawItemViewer(crashData);
		}
		
		//If at start
		if (itemViewerIndex == 0) {
			
			//Disable previous button
			previousButton.setEnabled(false);
		}
		else {
			
			previousButton.setEnabled(true);
		}

		//If at end
		if (itemViewerIndex == itemViewerListSize - 1) {
			
			//Disable next button
			nextButton.setEnabled(false);
		}
		else {
			
			nextButton.setEnabled(true);
		}
	}
	
	/**
	 * Sorts the table using the specified values
	 */
	private void sortTable() {
		
		//Sets up Comparator class for sort
		DataSorter ds = new DataSorter();
		DataSorter.setColumnNumber(ColumnData.values()[categoryChoice.getSelectedIndex()]);
		DataSorter.setIsAscending(directionChoice.getSelectedIndex() == 0);
		
		System.out.println("Sorting data...");
		
		//Sorts the data using the category and direction
		Collections.sort(crashData, ds);
		
		System.out.println("Sorting finished... Updating table");
		
		//Updates the table with the sorted data
		drawTableData(crashData, sortingTable, sortingTableModel);
		
		System.out.println("Successfully updated table\n");
	}
	
	/**
	 * Adds the UI required for a new search filter
	 */
	private void addSearchFilter() {
		
		//Removes buttons to place them at the bottom of the panel
		filterContainerPanel.remove(buttonControlPanel);
		filterContainerPanel.remove(gapLabel);
		filterContainerPanel.remove(searchResultLabel);
		
		//Add base panel container
		JPanel filterPanel = new JPanel();
		filterPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Filter", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		filterPanel.setMaximumSize(new Dimension(800, 100));
		filterPanel.setLayout(new BoxLayout(filterPanel, BoxLayout.Y_AXIS));
		filterPanel.setName("filterPanel");
		
		JPanel topPanel = new JPanel();
		topPanel.setMaximumSize(new Dimension(800, 100));
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
		
		//Comparison box
		Choice comparison = new Choice();
		comparison.addItem("==");
		comparison.addItem(">");
		comparison.addItem(">=");
		comparison.addItem("<");
		comparison.addItem("<=");
		
		comparison.setMaximumSize(new Dimension(80, 20));
		comparison.setMinimumSize(new Dimension(80, 20));
		
		//Category box
		Choice category = new Choice();
		for (int c = 0; c < columnHeaders.length; c++) {
			
			category.addItem(columnHeaders[c]);
		}
		category.setMaximumSize(new Dimension(180, 20));
		category.setMinimumSize(new Dimension(180, 20));
		category.addItemListener(new ItemListener() {
			//Update the contents of the comparison box based on category data type
			@Override
			public void itemStateChanged(ItemEvent e) {

				comparison.removeAll();
				comparison.addItem("==");
				List<String> stringValues = Arrays.asList(stringSearchTerms);
				List<String> booleanValues = Arrays.asList(boolSearchTerms);
				//If category is integer
				if (!stringValues.contains(category.getSelectedItem()) &&
						!booleanValues.contains(category.getSelectedItem())) {
					comparison.addItem(">");
					comparison.addItem(">=");
					comparison.addItem("<");
					comparison.addItem("<=");
				}
				//If category is String or boolean
				else if (!booleanValues.contains(category.getSelectedItem())) {
					comparison.addItem("Contains");
				}
			}
		});
		
		//Delete filter button
		JButton deleteButton = new JButton("Delete Filter");
		deleteButton.setAlignmentX(CENTER_ALIGNMENT);
		deleteButton.addActionListener(new ActionListener() {
			//Remove filter on click
			@Override
			public void actionPerformed(ActionEvent e) {
				filterContainerPanel.remove(filterPanel);
				filterContainerPanel.revalidate();
				filterContainerPanel.repaint();
			}
		});
		
		//Search text field for user parameter
		JTextField searchArea = new JTextField();
		searchArea.setMaximumSize(new Dimension(150, 22));
		searchArea.setMinimumSize(new Dimension(150, 22));
		
		//Add UI to panel
		topPanel.add(category);
		topPanel.add(new JLabel("    "));
		topPanel.add(comparison);
		topPanel.add(new JLabel("    "));
		topPanel.add(searchArea);
		filterPanel.add(topPanel);
		filterPanel.add(new JLabel(" "));
		filterPanel.add(deleteButton);
		filterContainerPanel.add(filterPanel);
		filterContainerPanel.add(buttonControlPanel);
		filterContainerPanel.add(gapLabel);
		filterContainerPanel.add(searchResultLabel);
	}
	
	/**
	 * Gets the search filters to apply by looping through UI components
	 * @return Returns an ArrayList of type String containing the search filters
	 */
	private ArrayList<String> getSearchFilters() {
		
		ArrayList<String> searchFilters = new ArrayList<String>();
		
		//Loops through the components in the filterContainerPanel
		for (Component component : filterContainerPanel.getComponents()) {
			
			//If component is a JPanel
			if (component instanceof JPanel &&
					!component.getName().equals("buttonControlPanel")) {
				
				//Component contains filter
				//Get the three filter components
				Component[] filterSections = ((JPanel)component).getComponents();
				Component[] filterComponents = ((JPanel)filterSections[0]).getComponents();
				String category = ((Choice)filterComponents[0]).getSelectedItem();
				String compareType = ((Choice)filterComponents[2]).getSelectedItem();
				String argument = ((JTextField)filterComponents[4]).getText();
				
				//Create filter string by combining component strings separated by commas
				String filterString = category + "," + compareType + "," + argument.toLowerCase();
				searchFilters.add(filterString);
				
			}
		}
		
		return searchFilters;
	}
	
	/**
	 * Update all of the statistics in the statistics tab
	 */
	private void updateStatsTab() {
		
		//Use search data
		if (statsCheckBox.getState() && 
				searchData.size() > 0) {
			
			drawStatsPiGraph(searchData);
			drawStatsBarGraph(searchData);
		}
		//Use normal data
		else {
			
			drawStatsPiGraph(crashData);
			drawStatsBarGraph(crashData);
		}
		updateStatsBox();
	}
	
	/**
	 * Draws the Pi graph related to the category type selected
	 * @param graphData Data to use for the graph
	 */
	private void drawStatsPiGraph(ArrayList<VehicleCrash> graphData) {
		
		String dataName = statsCategory.getSelectedItem();
		
		//Can't display a Row ID Pi chart due to 670000 categories
		if (!dataName.equals("Row ID")) {
			
			//Replace existing panel with graph
			Component existingPanel = statsPanel.getComponentAt(364, 11);
			
			if (existingPanel != null) {
				
				statsPanel.remove(existingPanel);
				statsPanel.repaint();
			}
			
			//Create data set
			DefaultPieDataset data = new DefaultPieDataset();
			
			int maxBucketVal = 0;
			List<String> columnListStr = Arrays.asList(stringSearchTerms);
			List<String> columnListBool = Arrays.asList(boolSearchTerms);

			//If integer
			if (!columnListStr.contains(dataName) &&
					!columnListBool.contains(dataName)) {
				
				//Count amount of different integers
				maxBucketVal = DataStatistics.getMax(graphData, dataName);
			}
			else {
				
				//Count amount of different strings/boolean
				maxBucketVal = DataStatistics.getDataValuesString(graphData, dataName).length;
			}
			
			//Create bucket
			int[] bucket = new int[maxBucketVal];
			
			//Fill bucket with frequency values based on data type
			if (!columnListStr.contains(dataName) &&
					!columnListBool.contains(dataName)) {
				
				bucket = DataStatistics.getBucket(graphData, dataName);
			}
			else {
				
				bucket = DataStatistics.getBucketString(graphData, dataName);
			}
			
			//Add values to the Pi Graph
			for (int value = 0; value < bucket.length; value++) {
			
				if (!dataName.equals("Crash Distance")) {
					
					if (bucket[value] != 0) { 
						
						if (!columnListStr.contains(dataName) &&
								!columnListBool.contains(dataName)) {
						
							data.setValue(((Integer)value).toString(), bucket[value]);
						}
						else {
							
							String[] valueNames = DataStatistics.getDataValuesString(graphData, dataName);
							data.setValue(valueNames[value], bucket[value]);
						}
					}
				}
				else {
					if (bucket[value] != 0) { 
						
						data.setValue(((Integer)(value * 1000)).toString() + " - " + ((Integer)((value + 1) * 1000)).toString(), bucket[value]);
					}
				}
			}
			
			//Create chart
			JFreeChart chart = ChartFactory.createPieChart("Frequency of " + dataName, data, true, true, Locale.ENGLISH);
			if (dataName.equals("Crash Distance")) ((PiePlot) chart.getPlot()).setLabelGenerator(null);
			
			//Add chart to panel
			ChartPanel graphPanel = new ChartPanel(chart);
			graphPanel.setVisible(true);
			graphPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			graphPanel.setBounds(364, 11, 497, 339);
			statsPanel.add(graphPanel);
			statsPanel.repaint();
		}
		else {
			
			//Display "Error cannot show Row ID as graph" message
			Component existingPanel = statsPanel.getComponentAt(364, 11);
			
			if (existingPanel != null) {
				
				statsPanel.remove(existingPanel);
				statsPanel.repaint();
			}
			
			JPanel graphPanel = new JPanel();
			graphPanel.setVisible(true);
			graphPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			graphPanel.setBounds(364, 11, 497, 339);
			graphPanel.add(new JLabel("Cannot display graph for Row ID"));
			statsPanel.add(graphPanel);
			statsPanel.repaint();
		}
	}
	
	/**
	 * Uses the passed in data set to create a bar graph for the statistics tab
	 * @param graphData Data set to be used to create the bar graph
	 */
	private void drawStatsBarGraph(ArrayList<VehicleCrash> graphData) {
		
		String dataName = statsCategory.getSelectedItem();
		
		//Can't create a graph for Row ID because of 670000 categories
		if (!dataName.equals("Row ID")) {
			
			//Removes existing panel
			Component existingPanel = statsPanel.getComponentAt(871, 11);
			
			if (existingPanel != null) {
				
				statsPanel.remove(existingPanel);
				statsPanel.repaint();
			}
			
			//Creates data set
			DefaultCategoryDataset  data = new DefaultCategoryDataset ();
			
			int maxBucketVal = 0;
			String secondLine = "";
			List<String> columnListStr = Arrays.asList(stringSearchTerms);
			List<String> columnListBool = Arrays.asList(boolSearchTerms);

			//Count different integers or strings
			if (!columnListStr.contains(dataName) &&
					!columnListBool.contains(dataName)) {
				
				secondLine = "\nWhere x > 0";
				maxBucketVal = DataStatistics.getMax(graphData, dataName);
			}
			else {
				
				maxBucketVal = DataStatistics.getDataValuesString(graphData, dataName).length;
			}
			
			//Create bucket
			int[] bucket = new int[maxBucketVal];
			
			//Get frequency of values
			if (!columnListStr.contains(dataName) &&
					!columnListBool.contains(dataName)) {
				
				bucket = DataStatistics.getBucket(graphData, dataName);
			}
			else {
				
				bucket = DataStatistics.getBucketString(graphData, dataName);
			}
			
			//Use bucket data to add data to graph
			if (!dataName.equals("Crash Distance")) {
				
				if (!columnListStr.contains(dataName) &&
						!columnListBool.contains(dataName)) {
				
					for (int value = 1; value < bucket.length; value++) {
						
						if (bucket[value] != 0) {
							
							data.addValue(bucket[value], dataName, ((Integer)value).toString());
						}
					}
				}
				else {
					
					for (int value = 0; value < bucket.length; value++) {
						
						String[] valueNames = DataStatistics.getDataValuesString(graphData, dataName);
						data.addValue(bucket[value], dataName, valueNames[value]);
					}
				}
			}
			else {
	
				for (int value = 1; value < bucket.length; value++) {
				
					if (bucket[value] != 0) { 
						
						data.addValue(bucket[value], dataName, ((Integer)(value * 1000)).toString() + " - " + ((Integer)((value + 1) * 1000)).toString());
					}
				}
			}
			
			ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());
			BarRenderer.setDefaultBarPainter(new StandardBarPainter());
			
			//Create chart
			JFreeChart chart = ChartFactory.createBarChart("Frequency of " + dataName + secondLine, "Amount", "Frequency", (CategoryDataset) data, PlotOrientation.VERTICAL, true, true, false);
			
			//Use 45 degree labels for long text or large amounts of categories
			if ((data.getColumnKey(0).toString().length() > 3 ||
					data.getColumnKey(1).toString().length() > 3) &&
					data.getColumnCount() > 4) {
				
				CategoryAxis axis = chart.getCategoryPlot().getDomainAxis();
				axis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
			}
			
			//Add chart to statistics panel
			ChartPanel graphPanel = new ChartPanel(chart);
			graphPanel.setVisible(true);
			graphPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			graphPanel.setBounds(871, 11, 497, 339);
			statsPanel.add(graphPanel);
			statsPanel.repaint();
		}
		else {
			
			//Display "Error cannot show Row ID as graph" message
			Component existingPanel = statsPanel.getComponentAt(871, 11);
			
			if (existingPanel != null) {
				
				statsPanel.remove(existingPanel);
				statsPanel.repaint();
			}
			
			JPanel graphPanel = new JPanel();
			graphPanel.setVisible(true);
			graphPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			graphPanel.setBounds(871, 11, 497, 339);
			graphPanel.add(new JLabel("Cannot display graph for Row ID"));
			statsPanel.add(graphPanel);
			statsPanel.repaint();
		}
	}
	
	/**
	 * Updates the statistics tables and the single data viewer
	 */
	private void updateStatsBox() {
		
		List<String> columnListStr = Arrays.asList(stringSearchTerms);
		List<String> columnListBool = Arrays.asList(boolSearchTerms);
		String dataName = statsCategory.getSelectedItem();
		
		//Use search data
		if (statsCheckBox.getState() &&
				searchData.size() > 0) {
			
			drawStatistics(searchData);
			if (!columnListStr.contains(dataName) &&
					!columnListBool.contains(dataName)) {
				
				topTen = DataStatistics.getTopTen(searchData, dataName);
				bottomTen = DataStatistics.getBottomTen(searchData, dataName);
			}
			else {
				
				topTen.clear();
				bottomTen.clear();
			}
			updateTopBottomStat(searchData, dataName);
		}
		else {
			
			drawStatistics(crashData);
			if (!columnListStr.contains(dataName) &&
					!columnListBool.contains(dataName)) {
				
				topTen = DataStatistics.getTopTen(crashData, dataName);
				bottomTen = DataStatistics.getBottomTen(crashData, dataName);
			}
			else {
				
				topTen.clear();
				bottomTen.clear();
			}
			updateTopBottomStat(crashData, dataName);
		}
		
		drawTableData(topTen, topTenTable, topTenTableModel);
		drawTableData(bottomTen, bottomTenTable, bottomTenTableModel);
	}
	
	/**
	 * Draw single view value from top or bottom ten tables
	 * @param data Data set to display
	 * @param dataName Category to use for statistics
	 */
	private void updateTopBottomStat(ArrayList<VehicleCrash> data, String dataName) {
		
		if (topBottomChoice.getSelectedItem().equals("Top 10 Table Data")) {
			
			drawTopTen(data, dataName);
		}
		else {
			
			drawBottomTen(data, dataName);
		}
	}
	
	/**
	 * Draws the statistical calculations to the UI
	 * @param crashes Data set to use for the calculations
	 */
	private void drawStatistics(ArrayList<VehicleCrash> crashes) {
		
		String textAreaString = "";
		String dataName = statsCategory.getSelectedItem();
		
		List<String> columnListStr = Arrays.asList(stringSearchTerms);
		List<String> columnListBool = Arrays.asList(boolSearchTerms);

		//Only display these for data type integer
		if (!columnListStr.contains(dataName) &&
				!columnListBool.contains(dataName)) {
			
			textAreaString += "Maximum: " + DataStatistics.getMax(crashes, dataName) + "\n(See Top 10 Table)\n";
			textAreaString += "Minimum: " + DataStatistics.getMin(crashes, dataName) + "\n(See Bottom 10 Table)\n";
			textAreaString += "Total: " + DataStatistics.getTotal(crashes, dataName) + "\n";
			textAreaString += "Mode: " + DataStatistics.getMode(crashes, dataName) + "\n";
		}
		
		//Display for data type String
		if (columnListStr.contains(dataName) ||
				columnListBool.contains(dataName)) {
			
			String[] valueNames = DataStatistics.getDataValuesString(crashes, dataName);
			textAreaString += "Mode: " + valueNames[DataStatistics.getModeString(crashes, dataName)] + "\n";
		}
		
		//Only display these for data type integer
		if (!columnListStr.contains(dataName) &&
				!columnListBool.contains(dataName)) {
			
			double mean = DataStatistics.getMean(crashes, dataName);
			textAreaString += "Mean: " + DataStatistics.round(mean, 2) + "\n";
			textAreaString += "Median: " + DataStatistics.round(DataStatistics.getMedian(crashes, dataName), 2) + "\n";
			double standardDeviation = DataStatistics.getStandardDeviation(crashes, dataName);
			textAreaString += "Standard Deviation: " + DataStatistics.round(standardDeviation, 2) + "\n";
			textAreaString += "1st Deviation: " + DataStatistics.getStandardDeviationLevel(1, standardDeviation, mean, true) + "\n";
			textAreaString += "2nd Deviation: " + DataStatistics.getStandardDeviationLevel(2, standardDeviation, mean, true) + "\n";
			textAreaString += "3rd Deviation: " + DataStatistics.getStandardDeviationLevel(3, standardDeviation, mean, true) + "\n";
		}
		
		//Add text to text panel
		statsTextPane1.setText(textAreaString);
	}
	
	/**
	 * Draws the specific value from the top ten table to the item viewer
	 * @param data Data set to use for item viewer
	 * @param dataName Category to use for statistics
	 */
	private void drawTopTen(ArrayList<VehicleCrash> data, String dataName) {
		
		//If integer data type
		if (topTen.size() > 0) {
			
			statsTextPane2.setFont(new Font("Tahoma", Font.PLAIN, 11));
			
			int valueIndex = (Integer)topBottomNumSpinner.getValue() - 1;
			if (valueIndex > topTen.size() - 1) valueIndex = topTen.size() - 1;
			statsTextPane2.setText(topTen.get((Integer)valueIndex).toString());
			
			statsTextPane2.setCaretPosition(0);
			topBottomNumSpinner.setEnabled(true);
		}
		//If string data type
		else {
			
			statsTextPane2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			statsTextPane2.setText(DataStatistics.getTopTenString(data, dataName));
			statsTextPane2.setCaretPosition(0);
			topBottomNumSpinner.setEnabled(false);
		}
	}
	
	/**
	 * Draws the specific value from the bottom ten table to the item viewer
	 * @param data Data set to use for the item viewer
	 * @param dataName Category to use for statistics
	 */
	private void drawBottomTen(ArrayList<VehicleCrash> data, String dataName) {
		
		//If integer data type
		if (bottomTen.size() > 0) {
			
			statsTextPane2.setFont(new Font("Tahoma", Font.PLAIN, 11));
			
			int valueIndex = (Integer)topBottomNumSpinner.getValue() - 1;
			if (valueIndex > bottomTen.size() - 1) valueIndex = bottomTen.size() - 1;
			statsTextPane2.setText(bottomTen.get((Integer)valueIndex).toString());
			
			statsTextPane2.setCaretPosition(0);
			topBottomNumSpinner.setEnabled(true);
		}
		//If string data type
		else {
			
			statsTextPane2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			statsTextPane2.setText(DataStatistics.getBottomTenString(data, dataName));
			statsTextPane2.setCaretPosition(0);
			topBottomNumSpinner.setEnabled(false);
		}
	}

	/**
	 * Event method for the Change Event
	 */
	@Override
	public void stateChanged(ChangeEvent arg0) {
		
		//If the number spinner has changed
		if (arg0.getSource().equals(topBottomNumSpinner)) {
			
			//Updates statistics tab item viewer
			updateStatsBox();
		}
	}
	
	/**
	 * Draws the current item to the item viewer
	 * @param data Data set to use for item viewer
	 */
	private void drawItemViewer(ArrayList<VehicleCrash> data) {
		
		itemView.setText(data.get(itemViewerIndex).toString());
		itemViewIndexLabel.setText("Currently viewing: " + (itemViewerIndex + 1) + "/" + itemViewerListSize);
	}
}
