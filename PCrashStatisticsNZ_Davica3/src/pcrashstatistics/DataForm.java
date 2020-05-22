package pcrashstatistics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

import org.jfree.chart.*;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.InvocationTargetException;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.border.EtchedBorder;
import java.util.List;
import java.util.Locale;

public class DataForm extends JFrame implements ItemListener, ActionListener, ChangeListener {

	private static final long serialVersionUID = 1L;
	
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
	private String[] stringSearchTerms = { 
			"Severity", "Vehicles Involved", "Location", "Junction Type", "Terrain Level", "Road Character", "Road Curvature", "Road Markings", "Road Surface", "Traffic Control", 
			"Light", "Weather A", "Weather B"
	};
	private String[] boolSearchTerms = {
			"At Intersection", "From Side Road", "On State Highway", "Road Is Wet"	
	};
	
	private int itemViewerIndex;
	private int itemViewerListSize;
	
	private JPanel contentPane;
	private ArrayList<VehicleCrash> crashData;
	private JTabbedPane tabbedPane;
	private JPanel sortPanel;
	private JPanel searchPanel;
	private JPanel statsPanel;
	private JPanel graphPanel;
	private JScrollPane scrollPane;
	private JTable sortingTable;
	private DefaultTableModel sortingTableModel;
	private DefaultTableModel searchTableModel;
	private DefaultTableModel topTenTableModel;
	private DefaultTableModel bottomTenTableModel;
	private JPanel sortSelection;
	private JPanel labelPanel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPanel choicePanel;
	private JButton sortButton;
	private JPanel infoSortSidePanel;
	private Choice categoryChoice;
	private Choice directionChoice;
	private JTextPane textPane;
	private JLabel imageheader;
	private JLabel sortLabel;
	
	private JScrollPane scrollPane_1;
	private ArrayList<VehicleCrash> searchData;
	private JTable searchTable;
	private JPanel searchFields;
	private JScrollPane filterScrollPane;
	private JPanel filterContainerPanel;
	private JButton addButton;
	private JPanel buttonControlPanel;
	private JButton applyButton;
	private JLabel lblNewLabel_2;
	private JLabel searchResultLabel;
	private JLabel gapLabel;
	private JPanel controlPanel1;
	private JPanel graph1Panel;
	private JPanel graph2Panel;
	private JPanel dataPanel;
	private JPanel top10Panel;
	private JPanel bottom10Panel;
	private JPanel displayPanel;
	private JPanel controlPanel2;
	private Choice statsCategory;
	private Checkbox statsCheckBox;
	private Choice topBottomChoice;
	private JSpinner topBottomNumSpinner;
	private JLabel lblNewLabel_3;
	private JTextPane statsTextPane1;
	private JTextPane statsTextPane2;
	private ArrayList<VehicleCrash> topTen;
	private ArrayList<VehicleCrash> bottomTen;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JTable topTenTable;
	private JTable bottomTenTable;
	private JLabel lblOfValue;
	private JScrollPane scrollPane_4;
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
	

	public DataForm(ArrayList<VehicleCrash> crashData) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		setVisible(true);
		setResizable(false);
		this.crashData = crashData;
		searchData = new ArrayList<VehicleCrash>();
		topTen = new ArrayList<VehicleCrash>();
		bottomTen = new ArrayList<VehicleCrash>();
		
		itemViewerIndex = 0;
		itemViewerListSize = 0;
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle formSize = new Rectangle(0, 0, 1400, 900);
		Rectangle formPosition = new Rectangle(
				(screenSize.width / 2) - (formSize.width / 2), 
				(screenSize.height / 2) - (formSize.height / 2),
				formSize.width,
				formSize.height);
		setBounds(formPosition);
		setTitle("Crash Statistics NZ (2000 - 2018)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setPreferredSize(new Dimension(800, 762));
		tabbedPane.setSize(new Dimension(800, 800));
		contentPane.add(tabbedPane);
		
		sortPanel = new JPanel();
		tabbedPane.addTab("Sort Data", null, sortPanel, null);
		sortPanel.setLayout(null);
		
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
		
		searchPanel = new JPanel();
		tabbedPane.addTab("Search Data", null, searchPanel, null);
		searchPanel.setLayout(null);
		
		statsPanel = new JPanel();
		tabbedPane.addTab("Data Statistics", null, statsPanel, null);
		statsPanel.setLayout(null);
		
		graphPanel = new JPanel();
		tabbedPane.addTab("Data Graphs", null, graphPanel, null);
		graphPanel.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setPreferredSize(new Dimension(800, 728));
		scrollPane_1.setMinimumSize(new Dimension(800, 760));
		scrollPane_1.setLocation(new Point(100, 100));
		scrollPane_1.setBounds(469, 11, 900, 802);
		searchPanel.add(scrollPane_1);
		
		sortingTableModel = new DefaultTableModel(new Object[][] {}, columnHeaders);
		searchTableModel = new DefaultTableModel(new Object[][] {}, columnHeaders);
		topTenTableModel = new DefaultTableModel(new Object[][] {}, columnHeaders);
		bottomTenTableModel = new DefaultTableModel(new Object[][] {}, columnHeaders);
		
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
		
		controlPanel1 = new JPanel();
		controlPanel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		controlPanel1.setBounds(10, 11, 344, 46);
		statsPanel.add(controlPanel1);
		
		statsCategory = new Choice();
		statsCategory.addItemListener(this);
		List<String> stringTermList = Arrays.asList(stringSearchTerms);
		List<String> boolTermList = Arrays.asList(boolSearchTerms);
		for (String category : columnHeaders) {
			if (!stringTermList.contains(category) &&
					!boolTermList.contains(category)) {
				statsCategory.add(category);
			}
		}
		controlPanel1.add(statsCategory);
		
		statsCheckBox = new Checkbox("Use Search Data");
		statsCheckBox.addItemListener(this);
		controlPanel1.add(statsCheckBox);
		
		graph1Panel = new JPanel();
		graph1Panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		graph1Panel.setBounds(364, 11, 497, 339);
		statsPanel.add(graph1Panel);
		
		graph2Panel = new JPanel();
		graph2Panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		graph2Panel.setBounds(871, 11, 497, 339);
		statsPanel.add(graph2Panel);
		
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
		
		repaint();
		
		updateItemViewer();
		updateStatsTab();
		drawTableData(crashData, sortingTable, sortingTableModel);
		drawTableData(crashData, searchTable, searchTableModel);
	}
	
	private void calculateColumnSizes(JTable table) {
		
		for (int column = 0; column < table.getColumnCount(); column++) {
			
		    TableColumn tableColumn = table.getColumnModel().getColumn(column);
		    int colWidth = tableColumn.getHeaderValue().toString().length();
		    
		    for (int row = 0; row < table.getRowCount(); row++) {
		    	
		    	Object value = table.getValueAt(row, column);
		    	String stringVal = "";
		    	
		    	if (value != null) stringVal = value.toString();
		    	
		    	int stringLen = 0;
		    	
		    	if (stringVal != null) stringLen = stringVal.length();
		    	
		    	if (stringLen > colWidth) {
		    		
		    		colWidth = stringLen;
		    	}
		    }
		    
		    tableColumn.setPreferredWidth( 10 + colWidth * 6 );
		}
	}
	
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

	@Override
	public void itemStateChanged(ItemEvent e) {

		if (e.getSource().equals(categoryChoice) || e.getSource().equals(directionChoice)) {
			if (sortLabel != null) sortLabel.setText("Sort by " + categoryChoice.getSelectedItem() + " " + directionChoice.getSelectedItem());
		}
		
		if (e.getSource().equals(statsCategory) || 
				e.getSource().equals(statsCheckBox)) {
			
			updateStatsBox();
		}
		
		if (e.getSource().equals(topBottomChoice)) {
			
			updateTopBottomStat();
		}
		
		if (e.getSource().equals(viewSearchData)) {
			itemViewerIndex = 0;
			updateItemViewer();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(sortButton)) {
			
			sortTable();
		}
		
		if (e.getSource().equals(addButton)) {
			
			addSearchFilter();
		}
		
		if (e.getSource().equals(applyButton)) {
			
			System.out.println("Searching using filters...");
			ArrayList<String> filters = getSearchFilters();
			searchData = DataSearcher.searchWithFilters(crashData, filters);
			System.out.println("Search finished... Updating table");
			drawTableData(searchData, searchTable, searchTableModel);
			System.out.println("Successfully updated table\n");
			
			if (filters.size() > 0) {
				
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
		
		if (e.getSource().equals(firstButton)) {
					
			itemViewerIndex = 0;
			updateItemViewer();
		}
		
		if (e.getSource().equals(previousButton)) {
			
			itemViewerIndex--;
			updateItemViewer();
		}
		
		if (e.getSource().equals(nextButton)) {
			
			itemViewerIndex++;
			updateItemViewer();
		}
		
		if (e.getSource().equals(lastButton)) {
			
			itemViewerIndex = itemViewerListSize - 1;
			updateItemViewer();
		}
	}
	
	private void updateItemViewer() {
		
		if (viewSearchData.isSelected() &&
				searchData.size() > 0) {
			
			itemViewerListSize = searchData.size();
;			drawItemViewer(searchData);
		}
		else {
			
			itemViewerListSize = crashData.size();
			drawItemViewer(crashData);
		}
		
		if (itemViewerIndex == 0) {
			
			previousButton.setEnabled(false);
		}
		else {
			
			previousButton.setEnabled(true);
		}

		if (itemViewerIndex == itemViewerListSize - 1) {
			
			nextButton.setEnabled(false);
		}
		else {
			
			nextButton.setEnabled(true);
		}
	}
	
	private void sortTable() {
		
		DataSorter ds = new DataSorter();
		DataSorter.setColumnNumber(ColumnData.values()[categoryChoice.getSelectedIndex()]);
		DataSorter.setIsAscending(directionChoice.getSelectedIndex() == 0);
		
		System.out.println("Sorting data...");
		Collections.sort(crashData, ds);
		System.out.println("Sorting finished... Updating table");
		drawTableData(crashData, sortingTable, sortingTableModel);
		System.out.println("Successfully updated table\n");
	}
	
	private void addSearchFilter() {
		
		filterContainerPanel.remove(buttonControlPanel);
		filterContainerPanel.remove(gapLabel);
		filterContainerPanel.remove(searchResultLabel);
		
		JPanel filterPanel = new JPanel();
		filterPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Filter", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		filterPanel.setMaximumSize(new Dimension(800, 100));
		filterPanel.setLayout(new BoxLayout(filterPanel, BoxLayout.Y_AXIS));
		filterPanel.setName("filterPanel");
		
		JPanel topPanel = new JPanel();
		topPanel.setMaximumSize(new Dimension(800, 100));
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
		

		Choice comparison = new Choice();
		comparison.addItem("==");
		comparison.addItem(">");
		comparison.addItem(">=");
		comparison.addItem("<");
		comparison.addItem("<=");
		
		comparison.setMaximumSize(new Dimension(80, 20));
		comparison.setMinimumSize(new Dimension(80, 20));
		
		Choice category = new Choice();
		for (int c = 0; c < columnHeaders.length; c++) {
			
			category.addItem(columnHeaders[c]);
		}
		category.setMaximumSize(new Dimension(180, 20));
		category.setMinimumSize(new Dimension(180, 20));
		category.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {

				comparison.removeAll();
				comparison.addItem("==");
				List<String> stringValues = Arrays.asList(stringSearchTerms);
				List<String> booleanValues = Arrays.asList(boolSearchTerms);
				if (!stringValues.contains(category.getSelectedItem()) &&
						!booleanValues.contains(category.getSelectedItem())) {
					comparison.addItem(">");
					comparison.addItem(">=");
					comparison.addItem("<");
					comparison.addItem("<=");
				}
				else if (!booleanValues.contains(category.getSelectedItem())) {
					comparison.addItem("Contains");
				}
			}
		});
		
		JButton deleteButton = new JButton("Delete Filter");
		deleteButton.setAlignmentX(CENTER_ALIGNMENT);
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				filterContainerPanel.remove(filterPanel);
				filterContainerPanel.revalidate();
				filterContainerPanel.repaint();
			}
		});
		
		JTextField searchArea = new JTextField();
		searchArea.setMaximumSize(new Dimension(150, 22));
		searchArea.setMinimumSize(new Dimension(150, 22));
		
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
	
	private ArrayList<String> getSearchFilters() {
		
		ArrayList<String> searchFilters = new ArrayList<String>();
		
		for (Component component : filterContainerPanel.getComponents()) {
			
			if (component instanceof JPanel &&
					!component.getName().equals("buttonControlPanel")) {
				
				Component[] filterSections = ((JPanel)component).getComponents();
				Component[] filterComponents = ((JPanel)filterSections[0]).getComponents();
				String category = ((Choice)filterComponents[0]).getSelectedItem();
				String compareType = ((Choice)filterComponents[2]).getSelectedItem();
				String argument = ((JTextField)filterComponents[4]).getText();
				
				String filterString = category + "," + compareType + "," + argument.toLowerCase();
				searchFilters.add(filterString);
				
			}
		}
		
		return searchFilters;
	}
	
	private void updateStatsTab() {
		
		drawStatsPiGraph();
		List<String> columnListStr = Arrays.asList(stringSearchTerms);
		List<String> columnListBool = Arrays.asList(stringSearchTerms);
		if (columnListStr.contains(statsCategory.getSelectedItem()) ||
				columnListBool.contains(statsCategory.getSelectedItem())) {
			
			drawStatsBarGraph();
		}
		else {
			
			drawStatsStanDevGraph();
		}
		updateStatsBox();
		updateTopBottomStat();
	}
	
	private void drawStatsPiGraph() {
		
		DefaultPieDataset data = new DefaultPieDataset();
		int[] bucket = DataStatistics.getBucket(crashData, statsCategory.getSelectedItem()); //NOT ROW ID VERY BAD
		
		for (int value = 0; value < bucket.length; value++) {
		
			if (bucket[value] != 0) { 
				
				data.setValue(((Integer)value).toString(), bucket[value]);
			}
		}
		
		JFreeChart chart = ChartFactory.createPieChart("Frequency of " + statsCategory.getSelectedItem(), data, true, true, Locale.ENGLISH);
		
		ChartPanel graphPanel = new ChartPanel(chart);
		graphPanel.setVisible(true);
		
		tabbedPane.addTab("Test Graph", graphPanel);
	}
	
	private void drawStatsBarGraph() {
		
		
	}
	
	private void drawStatsStanDevGraph() {
		
		
	}
	
	private void updateStatsBox() {
		
		if (statsCheckBox.getState() &&
				searchData.size() > 0) {
			
			drawStatistics(searchData);
			topTen = DataStatistics.getTopTen(searchData, statsCategory.getSelectedItem());
			bottomTen = DataStatistics.getBottomTen(searchData, statsCategory.getSelectedItem());
		}
		else {
			
			drawStatistics(crashData);
			topTen = DataStatistics.getTopTen(crashData, statsCategory.getSelectedItem());
			bottomTen = DataStatistics.getBottomTen(crashData, statsCategory.getSelectedItem());
		}
		
		updateTopBottomStat();
		drawTableData(topTen, topTenTable, topTenTableModel);
		drawTableData(bottomTen, bottomTenTable, bottomTenTableModel);
	}
	
	private void updateTopBottomStat() {
		
		if (topBottomChoice.getSelectedItem().equals("Top 10 Table Data")) {
			
			drawTopTen();
		}
		else {
			
			drawBottomTen();
		}
	}
	
	private void drawStatistics(ArrayList<VehicleCrash> crashes) {
		
		String textAreaString = "";
		
		textAreaString += "Maximum: " + DataStatistics.getMax(crashes, statsCategory.getSelectedItem()) + "\n(See Top 10 Table)\n";
		textAreaString += "Minimum: " + DataStatistics.getMin(crashes, statsCategory.getSelectedItem()) + "\n(See Bottom 10 Table)\n";
		textAreaString += "Total: " + DataStatistics.getTotal(crashes, statsCategory.getSelectedItem()) + "\n";
		double mean = DataStatistics.getMean(crashes, statsCategory.getSelectedItem());
		textAreaString += "Mean: " + DataStatistics.round(mean, 2) + "\n";
		textAreaString += "Median: " + DataStatistics.round(DataStatistics.getMedian(crashes, statsCategory.getSelectedItem()), 2) + "\n";
		textAreaString += "Mode: " + DataStatistics.getMode(crashes, statsCategory.getSelectedItem()) + "\n";
		double standardDeviation = DataStatistics.getStandardDeviation(crashes, statsCategory.getSelectedItem());
		textAreaString += "Standard Deviation: " + DataStatistics.round(standardDeviation, 2) + "\n";
		textAreaString += "1st Deviation: " + DataStatistics.getStandardDeviationLevel(1, standardDeviation, mean, true) + "\n";
		textAreaString += "2nd Deviation: " + DataStatistics.getStandardDeviationLevel(2, standardDeviation, mean, true) + "\n";
		textAreaString += "3rd Deviation: " + DataStatistics.getStandardDeviationLevel(3, standardDeviation, mean, true) + "\n";
		
		statsTextPane1.setText(textAreaString);
	}
	
	private void drawTopTen() {
		
		statsTextPane2.setText(topTen.get((Integer)topBottomNumSpinner.getValue() - 1).toString());
		statsTextPane2.setCaretPosition(0);
	}
	
	private void drawBottomTen() {
		
		statsTextPane2.setText(bottomTen.get((Integer)topBottomNumSpinner.getValue() - 1).toString());
		statsTextPane2.setCaretPosition(0);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		
		if (arg0.getSource().equals(topBottomNumSpinner)) {
			updateTopBottomStat();
		}
	}
	
	private void drawItemViewer(ArrayList<VehicleCrash> data) {
		
		itemView.setText(data.get(itemViewerIndex).toString());
		itemViewIndexLabel.setText("Currently viewing: " + (itemViewerIndex + 1) + "/" + itemViewerListSize);
	}
}
