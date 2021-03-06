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
package gov.nist.appvet.gwt.client;

import gov.nist.appvet.gwt.shared.AppsListGwt;
import gov.nist.appvet.gwt.shared.ConfigInfoGwt;
import gov.nist.appvet.gwt.shared.ServerPacket;
import gov.nist.appvet.gwt.shared.SystemAlert;
import gov.nist.appvet.gwt.shared.ToolInfoGwt;
import gov.nist.appvet.gwt.shared.ToolStatusGwt;
import gov.nist.appvet.shared.all.DeviceOS;
import gov.nist.appvet.shared.all.UserInfo;
import gov.nist.appvet.shared.all.UserToolCredentials;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author steveq@nist.gov
 */
public interface GWTServiceAsync {
	
	void setTestToolsEnabledDisabled(ArrayList<ToolInfoGwt> newToolInfo, 
			AsyncCallback<Boolean> callback)
					throws IllegalArgumentException;
		
	void getTestToolsEnabledDisabled(AsyncCallback<List<ToolInfoGwt>> callback)
			throws IllegalArgumentException;
	
	void getAppLog(String appId, AsyncCallback<String> callback)
			throws IllegalArgumentException;
	
	void getAppVetLog(AsyncCallback<String> callback)
			throws IllegalArgumentException;
	
	void setAlertMessage(String username, SystemAlert alert,
			AsyncCallback<Boolean> callback)
			throws IllegalArgumentException;
	
	void clearAlertMessage(String username,
			AsyncCallback<Boolean> callback)
			throws IllegalArgumentException;
	
	void adminSetUser(UserInfo userInfo,
			AsyncCallback<List<UserInfo>> callback)
			throws IllegalArgumentException;
	
	void getOrgHierarchies(AsyncCallback<List<String>> callback)
			throws IllegalArgumentException;
	
	void handleServletRequest(
			AsyncCallback<ConfigInfoGwt> callback)
			throws IllegalArgumentException;		

	void authenticateNonSSO(String username, String password, 
			AsyncCallback<ConfigInfoGwt> callback)
			throws IllegalArgumentException;
	
	void clearLog(AsyncCallback<Boolean> callback)
			throws IllegalArgumentException;

	void deleteApp(DeviceOS os, String appId, String username,
			AsyncCallback<Boolean> callback) throws IllegalArgumentException;

	void deleteUser(String username, AsyncCallback<List<UserInfo>> callback)
			throws IllegalArgumentException;
	
	void reactivateUser(String username, AsyncCallback<List<UserInfo>> callback)
			throws IllegalArgumentException;

	void getAllApps(String username, AsyncCallback<AppsListGwt> callback)
			throws IllegalArgumentException;

	void getToolsResults(DeviceOS os, String sessionId, String appId,
			AsyncCallback<List<ToolStatusGwt>> callback)
			throws IllegalArgumentException;

	void getAllUsers(AsyncCallback<List<UserInfo>> callback)
			throws IllegalArgumentException;

	void removeSession(String sessionId, AsyncCallback<Boolean> callback)
			throws IllegalArgumentException;

	void selfUpdatePassword(UserInfo userInfo, AsyncCallback<Boolean> callback)
			throws IllegalArgumentException;

	void updateUserToolCredentials(String username,
			ArrayList<UserToolCredentials> credentialsList,
			AsyncCallback<Boolean> callback) throws IllegalArgumentException;
	
	void getServerUpdates(String username, String sessionId, 
			Date sessionExpiration, Date lastAppsListUpdate, AsyncCallback<ServerPacket> serverPacket)
		throws IllegalArgumentException;
	
}
