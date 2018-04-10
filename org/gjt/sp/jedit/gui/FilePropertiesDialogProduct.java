package org.gjt.sp.jedit.gui;


import javax.swing.JButton;
import javax.swing.JPanel;
import org.gjt.sp.jedit.gui.FilePropertiesDialog.ButtonActionHandler;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import org.gjt.sp.jedit.jEdit;
import org.gjt.sp.util.GenericGUIUtilities;
import javax.swing.Box;
import java.io.Serializable;

public class FilePropertiesDialogProduct implements Serializable {
	private JButton okButton;
	private JButton cancelButton;

	public JButton getOkButton() {
		return okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public JPanel createSouthPanel(FilePropertiesDialog filePropertiesDialog) {
		ButtonActionHandler actionHandler = filePropertiesDialog.new ButtonActionHandler();
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(17, 0, 0, 0));
		okButton = new JButton(jEdit.getProperty("fileprop.okBtn"));
		okButton.addActionListener(actionHandler);
		filePropertiesDialog.getRootPane().setDefaultButton(okButton);
		cancelButton = new JButton(jEdit.getProperty("fileprop.cancelBtn"));
		cancelButton.addActionListener(actionHandler);
		GenericGUIUtilities.makeSameSize(okButton, cancelButton);
		panel.add(Box.createGlue());
		panel.add(okButton);
		panel.add(Box.createHorizontalStrut(6));
		panel.add(cancelButton);
		return panel;
	}
}