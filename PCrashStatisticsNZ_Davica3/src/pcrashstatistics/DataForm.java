package pcrashstatistics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.InvocationTargetException;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.util.List;

public class DataForm extends JFrame implements ItemListener, ActionListener {

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
	
	private JPanel contentPane;
	private ArrayList<VehicleCrash> crashData;
	private JTabbedPane tabbedPane;
	private JPanel sortPanel;
	private JPanel searchPanel;
	private JPanel statsPanel;
	private JPanel graphPanel;
	private JScrollPane scrollPane;
	private JTable sortTable;
	private DefaultTableModel tableModel;
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
	

	public DataForm(ArrayList<VehicleCrash> crashData) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		setVisible(true);
		setResizable(false);
		this.crashData = crashData;
		
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
		
		searchPanel = new JPanel();
		tabbedPane.addTab("Search Data", null, searchPanel, null);
		searchPanel.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setPreferredSize(new Dimension(800, 728));
		scrollPane_1.setMinimumSize(new Dimension(800, 760));
		scrollPane_1.setLocation(new Point(100, 100));
		scrollPane_1.setBounds(469, 11, 900, 802);
		searchPanel.add(scrollPane_1);
		
		tableModel = new DefaultTableModel(
				new Object[][] {
				},
				columnHeaders
			);
		
		searchTable = new JTable();
		searchTable.setRowSelectionAllowed(false);
		searchTable.setEnabled(false);
		searchTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		searchTable.setModel(tableModel);	
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
		
		statsPanel = new JPanel();
		tabbedPane.addTab("Data Statistics", null, statsPanel, null);
		statsPanel.setLayout(null);
		
		graphPanel = new JPanel();
		tabbedPane.addTab("Graph Data", null, graphPanel, null);
		graphPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setLocation(new Point(100, 100));
		scrollPane.setBounds(10, 11, 900, 802);
		scrollPane.setPreferredSize(new Dimension(800, 728));
		scrollPane.setMinimumSize(new Dimension(800, 760));
		sortPanel.add(scrollPane);
		
		sortTable = new JTable();
		sortTable.setRowSelectionAllowed(false);
		sortTable.setEnabled(false);
		sortTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		sortTable.setModel(tableModel);
		scrollPane.setViewportView(sortTable);
		
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
		
		drawTableData();
		drawSearchTableData(crashData);
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
	
	public void drawTableData() {
		calculateColumnSizes(sortTable);
		
		tableModel.setRowCount(0);
		for (int r = 0; r < crashData.size(); r++) {
			
			Object[] object = new Object[64];
			
			VehicleCrash crash = crashData.get(r);
			
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
		
		calculateColumnSizes(sortTable);
	}
	
	public void drawSearchTableData(ArrayList<VehicleCrash> searchResults) {
		calculateColumnSizes(searchTable);
		
		tableModel.setRowCount(0);
		for (int r = 0; r < searchResults.size(); r++) {
			
			Object[] object = new Object[64];
			
			VehicleCrash crash = searchResults.get(r);
			
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
		
		calculateColumnSizes(searchTable);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		if (e.getSource().equals(categoryChoice) || e.getSource().equals(directionChoice)) {
			if (sortLabel != null) sortLabel.setText("Sort by " + categoryChoice.getSelectedItem() + " " + directionChoice.getSelectedItem());
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
			
			ArrayList<String> filters = getSearchFilters();
			ArrayList<VehicleCrash> results = DataSearcher.searchWithFilters(crashData, filters);
			drawSearchTableData(results);
			if (filters.size() > 0) {
				if (results.size() == 1) {
					searchResultLabel.setText("\nSearch found " + results.size() + " result");
				}
				else {
					searchResultLabel.setText("\nSearch found " + results.size() + " results");
				}
				searchResultLabel.setVisible(true);
			}
			else {
				searchResultLabel.setVisible(false);
			}
		}
	}
	
	private void sortTable() {
		
		DataSorter ds = new DataSorter();
		DataSorter.setColumnNumber(ColumnData.values()[categoryChoice.getSelectedIndex()]);
		DataSorter.setIsAscending(directionChoice.getSelectedIndex() == 0);
		
		System.out.println("Sorting data...");
		Collections.sort(crashData, ds);
		System.out.println("Sorting finished... Updating table");
		drawTableData();
		System.out.println("Successfully updated table");
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
				
				String filterString = category + "," + compareType + "," + argument;
				searchFilters.add(filterString);
				
			}
		}
		
		return searchFilters;
	}
}
