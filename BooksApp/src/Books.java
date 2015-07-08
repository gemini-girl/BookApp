import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class Books {

	protected Shell shell;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text searchText;
	private Table searchresultstable;
	private Text FNameText;
	private Text LNametext;
	private Text edNumtext;
	private Text ISBNText;
	private Text titleText;
	private Text copytext;
	private Label lblNewLabel;
	private Label lblLastName;
	private Label lblIsbn;
	private Label lblTitle;
	private Label lblNewLabel_1;
	private Label lblCopy;
	private Table inserttable;
	private Button btnInsert;
	private Text UpdateSearchtext;
	private Button updatebuton;
	private Text upfntext;
	private Text uplntext;
	private Text uptitletext;
	private Label lblEditTheRecord;
	private Label lblFirstName;
	private Label lblLastName_1;
	private Label lblTitle_1;
	private TabItem tbtmUpdateTab;
	private Text upeditnumtext;
	private Text upcopytext;
	private Label lblCopy_1;
	private Label lblEd;
	private Button btnUpdate;
	private Button btnClear;
	private Table table;
	private Label lblEditedRecord;
	private Label lblInsertedRecord;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Books window = new Books();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(523, 530);
		shell.setText("Books Application");
		
		TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
		tabFolder.setBounds(21, 21, 459, 445);
		
		TabItem tbtmSearchTab = new TabItem(tabFolder, SWT.NONE);
		tbtmSearchTab.setText("Search tab");
		
		Composite searchComposite = new Composite(tabFolder, SWT.NONE);
		tbtmSearchTab.setControl(searchComposite);
		formToolkit.paintBordersFor(searchComposite);
		
		searchText = new Text(searchComposite, SWT.BORDER);
		searchText.setBounds(27, 26, 221, 21);
		formToolkit.adapt(searchText, true, true);
		
		Button btnSearch = new Button(searchComposite, SWT.NONE);
		btnSearch.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnSearch.setBounds(270, 24, 75, 25);
		formToolkit.adapt(btnSearch, true, true);
		btnSearch.setText("Search");
		
		searchresultstable = new Table(searchComposite, SWT.BORDER | SWT.FULL_SELECTION);
		searchresultstable.setBounds(27, 84, 390, 89);
		formToolkit.adapt(searchresultstable);
		formToolkit.paintBordersFor(searchresultstable);
		searchresultstable.setHeaderVisible(true);
		searchresultstable.setLinesVisible(true);
		
		Label lblResults = new Label(searchComposite, SWT.NONE);
		lblResults.setBounds(27, 63, 55, 15);
		formToolkit.adapt(lblResults, true, true);
		lblResults.setText("Results:");
		
		TabItem tbtmInsertTab = new TabItem(tabFolder, SWT.NONE);
		tbtmInsertTab.setText("Insert Tab");
		
		Composite insertComposite = new Composite(tabFolder, SWT.NONE);
		tbtmInsertTab.setControl(insertComposite);
		formToolkit.paintBordersFor(insertComposite);
		
		FNameText = new Text(insertComposite, SWT.BORDER);
		FNameText.setBounds(37, 34, 114, 21);
		formToolkit.adapt(FNameText, true, true);
		
		LNametext = new Text(insertComposite, SWT.BORDER);
		LNametext.setBounds(178, 34, 105, 21);
		formToolkit.adapt(LNametext, true, true);
		
		edNumtext = new Text(insertComposite, SWT.BORDER);
		edNumtext.setBounds(37, 149, 114, 21);
		formToolkit.adapt(edNumtext, true, true);
		
		ISBNText = new Text(insertComposite, SWT.BORDER);
		ISBNText.setBounds(37, 90, 114, 21);
		formToolkit.adapt(ISBNText, true, true);
		
		titleText = new Text(insertComposite, SWT.BORDER);
		titleText.setBounds(178, 90, 105, 21);
		formToolkit.adapt(titleText, true, true);
		
		copytext = new Text(insertComposite, SWT.BORDER);
		copytext.setBounds(178, 149, 105, 21);
		formToolkit.adapt(copytext, true, true);
		
		lblNewLabel = new Label(insertComposite, SWT.NONE);
		lblNewLabel.setBounds(36, 13, 70, 15);
		formToolkit.adapt(lblNewLabel, true, true);
		lblNewLabel.setText("First Name");
		
		lblLastName = new Label(insertComposite, SWT.NONE);
		lblLastName.setBounds(178, 13, 60, 15);
		formToolkit.adapt(lblLastName, true, true);
		lblLastName.setText("Last Name");
		
		lblIsbn = new Label(insertComposite, SWT.NONE);
		lblIsbn.setBounds(37, 71, 55, 15);
		formToolkit.adapt(lblIsbn, true, true);
		lblIsbn.setText("ISBN");
		
		lblTitle = new Label(insertComposite, SWT.NONE);
		lblTitle.setBounds(178, 69, 55, 15);
		formToolkit.adapt(lblTitle, true, true);
		lblTitle.setText("Title");
		
		lblNewLabel_1 = new Label(insertComposite, SWT.NONE);
		lblNewLabel_1.setBounds(37, 128, 96, 15);
		formToolkit.adapt(lblNewLabel_1, true, true);
		lblNewLabel_1.setText("Edition Number");
		
		lblCopy = new Label(insertComposite, SWT.NONE);
		lblCopy.setBounds(178, 128, 55, 15);
		formToolkit.adapt(lblCopy, true, true);
		lblCopy.setText("Copy");
		
		inserttable = new Table(insertComposite, SWT.BORDER | SWT.FULL_SELECTION);
		inserttable.setBounds(37, 203, 377, 127);
		formToolkit.adapt(inserttable);
		formToolkit.paintBordersFor(inserttable);
		inserttable.setHeaderVisible(true);
		inserttable.setLinesVisible(true);
		
		btnInsert = new Button(insertComposite, SWT.NONE);
		btnInsert.setBounds(311, 147, 75, 25);
		formToolkit.adapt(btnInsert, true, true);
		btnInsert.setText("Insert");
		
		btnClear = new Button(insertComposite, SWT.NONE);
		btnClear.setBounds(311, 86, 75, 25);
		formToolkit.adapt(btnClear, true, true);
		btnClear.setText("Clear ");
		
		lblInsertedRecord = new Label(insertComposite, SWT.NONE);
		lblInsertedRecord.setBounds(37, 182, 96, 15);
		formToolkit.adapt(lblInsertedRecord, true, true);
		lblInsertedRecord.setText("Inserted Record");
		
		tbtmUpdateTab = new TabItem(tabFolder, SWT.NONE);
		tbtmUpdateTab.setText("Update Tab");
		
		Composite updateComposite = new Composite(tabFolder, SWT.NONE);
		tbtmUpdateTab.setControl(updateComposite);
		formToolkit.paintBordersFor(updateComposite);
		
		UpdateSearchtext = new Text(updateComposite, SWT.BORDER);
		UpdateSearchtext.setBounds(47, 34, 204, 21);
		formToolkit.adapt(UpdateSearchtext, true, true);
		
		updatebuton = new Button(updateComposite, SWT.NONE);
		updatebuton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		updatebuton.setBounds(257, 32, 75, 25);
		formToolkit.adapt(updatebuton, true, true);
		updatebuton.setText("Search");
		
		upfntext = new Text(updateComposite, SWT.BORDER);
		upfntext.setBounds(47, 120, 131, 21);
		formToolkit.adapt(upfntext, true, true);
		
		uplntext = new Text(updateComposite, SWT.BORDER);
		uplntext.setBounds(226, 120, 76, 21);
		formToolkit.adapt(uplntext, true, true);
		
		uptitletext = new Text(updateComposite, SWT.BORDER);
		uptitletext.setBounds(47, 184, 97, 21);
		formToolkit.adapt(uptitletext, true, true);
		
		lblEditTheRecord = new Label(updateComposite, SWT.NONE);
		lblEditTheRecord.setBounds(47, 74, 131, 15);
		formToolkit.adapt(lblEditTheRecord, true, true);
		lblEditTheRecord.setText("Edit the Record Below:");
		
		lblFirstName = new Label(updateComposite, SWT.NONE);
		lblFirstName.setBounds(45, 99, 89, 15);
		formToolkit.adapt(lblFirstName, true, true);
		lblFirstName.setText("First Name");
		
		lblLastName_1 = new Label(updateComposite, SWT.NONE);
		lblLastName_1.setText("Last Name");
		lblLastName_1.setBounds(226, 99, 89, 15);
		formToolkit.adapt(lblLastName_1, true, true);
		
		lblTitle_1 = new Label(updateComposite, SWT.NONE);
		lblTitle_1.setText("Title");
		lblTitle_1.setBounds(47, 163, 89, 15);
		formToolkit.adapt(lblTitle_1, true, true);
		
		upeditnumtext = new Text(updateComposite, SWT.BORDER);
		upeditnumtext.setBounds(179, 184, 106, 21);
		formToolkit.adapt(upeditnumtext, true, true);
		
		upcopytext = new Text(updateComposite, SWT.BORDER);
		upcopytext.setBounds(319, 184, 89, 21);
		formToolkit.adapt(upcopytext, true, true);
		
		lblCopy_1 = new Label(updateComposite, SWT.NONE);
		lblCopy_1.setText("Edition Number");
		lblCopy_1.setBounds(179, 163, 89, 15);
		formToolkit.adapt(lblCopy_1, true, true);
		
		lblEd = new Label(updateComposite, SWT.NONE);
		lblEd.setText("Copy");
		lblEd.setBounds(319, 163, 89, 15);
		formToolkit.adapt(lblEd, true, true);
		
		btnUpdate = new Button(updateComposite, SWT.NONE);
		btnUpdate.setBounds(198, 220, 75, 25);
		formToolkit.adapt(btnUpdate, true, true);
		btnUpdate.setText("Update");
		
		table = new Table(updateComposite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(47, 283, 361, 78);
		formToolkit.adapt(table);
		formToolkit.paintBordersFor(table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		lblEditedRecord = new Label(updateComposite, SWT.NONE);
		lblEditedRecord.setBounds(47, 262, 87, 15);
		formToolkit.adapt(lblEditedRecord, true, true);
		lblEditedRecord.setText("Edited Record");

	}
}
