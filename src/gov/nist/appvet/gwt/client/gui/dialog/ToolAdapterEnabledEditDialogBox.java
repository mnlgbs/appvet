/* This software was developed by employees of the National Institute of
 * Standards and Technology (NIST), an agency of the Federal Government.
 * Pursuant to title 15 United States Code Section 105, works of NIST
 * employees are not subject to copyright protection in the United States
 * and are considered to be in the public domain.  As a result, a formal
 * license is not needed to use the software.
 * 
 * This software is provided by NIST as a service and is expressly
 * provided "AS IS".  NIST MAKES NO WARRANTY OF ANY KIND, EXPRESS, IMPLIED
 * OR STATUTORY, INCLUDING, WITHOUT LIMITATION, THE IMPLIED WARRANTY OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NON-INFRINGEMENT
 * AND DATA ACCURACY.  NIST does not warrant or make any representations
 * regarding the use of the software or the results thereof including, but
 * not limited to, the correctness, accuracy, reliability or usefulness of
 * the software.
 * 
 * Permission to use this software is contingent upon your acceptance
 * of the terms of this agreement.
 */
package gov.nist.appvet.gwt.client.gui.dialog;


import java.util.List;
import java.util.logging.Logger;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.user.client.ui.RadioButton;

/**
 * @author steveq@nist.gov
 */
public class ToolAdapterEnabledEditDialogBox extends DialogBox {
	public PushButton cancelButton = null;
	public Label mainLabel = null;
//	public FileUpload fileUpload = null;
	public PushButton okButton = null;
//	public Hidden hiddenAppPackage = null;
//	public Hidden hiddenAppVersion = null;
//	public Hidden hiddenAppOS = null;
	public Label statusLabel = null;
	public List<String> allUserOrgLevels = null;
	private Logger log = Logger.getLogger("ToolAdapterEnabledEditDialogBox");
//	public SuggestBox suggestBox = null;
//	public String orgMembership;

	public ToolAdapterEnabledEditDialogBox(String toolId, String os, boolean toolAdapterEnabled) {
		super(false, true);
//		this.orgMembership = orgMembership;
		setWidth("200px");
		setAnimationEnabled(false);
//		this.allUserOrgLevels = allUserOrgLevels;
		final VerticalPanel mainPanel = new VerticalPanel();
		mainPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		mainPanel.addStyleName("mainPanel");
		this.setWidget(mainPanel);
		mainPanel.setSize("", "141px");

		// Set label
//		int index = selectedIndex + 1; // Index must start at 1, not 0
		mainLabel = new Label("Enable or disable tool");
		mainPanel.add(mainLabel);
		mainLabel.setDirection(Direction.LTR);
		mainPanel.setCellVerticalAlignment(mainLabel,
				HasVerticalAlignment.ALIGN_MIDDLE);
		mainLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		mainLabel.setSize("", "32px");

//		MultiWordSuggestOracle suggestOracle = getOracle(selectedIndex);
		
		RadioButton enableRadioButton = new RadioButton("Enable", "Enable");
		mainPanel.add(enableRadioButton);
		enableRadioButton.setHeight("20px");
		
		RadioButton disableRadioButton = new RadioButton("new name", "Disable");
		mainPanel.add(disableRadioButton);
		disableRadioButton.setHeight("20px");

		final HorizontalPanel horizontalButtonPanel = new HorizontalPanel();
		horizontalButtonPanel.setStyleName("buttonPanel");
		mainPanel.add(horizontalButtonPanel);
		horizontalButtonPanel.setSize("270px", "50px");
		horizontalButtonPanel
		.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		mainPanel.setCellVerticalAlignment(horizontalButtonPanel,
				HasVerticalAlignment.ALIGN_MIDDLE);
		mainPanel.setCellHorizontalAlignment(horizontalButtonPanel,
				HasHorizontalAlignment.ALIGN_CENTER);
		horizontalButtonPanel.setSpacing(10);
		horizontalButtonPanel
		.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		cancelButton = new PushButton("Cancel");
		cancelButton.setStyleName("grayButton shadow");
		cancelButton.setHTML("Cancel");
		horizontalButtonPanel.add(cancelButton);
		horizontalButtonPanel.setCellHorizontalAlignment(cancelButton,
				HasHorizontalAlignment.ALIGN_CENTER);
		cancelButton.setSize("70px", "18px");
		okButton = new PushButton("Ok");
		okButton.setStyleName("greenButton shadow");
		horizontalButtonPanel.add(okButton);
		horizontalButtonPanel.setCellHorizontalAlignment(okButton,
				HasHorizontalAlignment.ALIGN_CENTER);
		okButton.setSize("70px", "18px");

	}

//	/** Generate suggestions based on existing user org hierarchy membership paths.*/
//	public MultiWordSuggestOracle getOracle(int selectedIndex) {
//		MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
//
//		try {
//			String[] selectedUserMembership = orgMembership.split(",");
//			if (allUserOrgLevels == null) {
//				log.warning("Hierarchies is null");
//				return oracle;
//			}
//
//			for (int i = 0; i < allUserOrgLevels.size(); i++) {
//
//				boolean onHeirarchyPath = true;
//				String otherUserMembershipStr = allUserOrgLevels.get(i);
//				String[] otherUserMembership = otherUserMembershipStr.split(",");
//
//				for (int j = 0; j < selectedIndex; j++) {
//
//					if (orgMembership == null || orgMembership.isEmpty()) {
//
//						break;
//					} else if (selectedUserMembership[j].equals(otherUserMembership[j])) {
//
//						// Do nothing
//					} else {
//
//						onHeirarchyPath = false;
//						break;
//					}
//				}
//				
//				if (onHeirarchyPath) {
//
//					oracle.add(otherUserMembership[selectedIndex]);
//				}
//			}
//
//		} catch (Exception e) {
//
//			log.severe(e.getMessage());
//		}
//		return oracle;
//
//	}
}
