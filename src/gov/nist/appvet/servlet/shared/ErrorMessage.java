package gov.nist.appvet.servlet.shared;

/**
 * @author steveq@nist.gov
 */
public enum ErrorMessage {
	INVALID_FILE("ERROR: INVALID FILE ATTACHMENT"), 
	INVALID_APP_FILE("ERROR: INVALID APP FILE"), 
	INVALID_APP_FILE_EXTENSION("ERROR: INVALID APP FILE EXTENSION"), 
	INVALID_REPORT_FILE_EXTENSION("ERROR: INVALID REPORT FILE EXTENSION"), 
	INVALID_APPID(
			"ERROR: INVALID APP ID"), INVALID_TOOLID("ERROR: INVALID TOOL ID"), UNKNOWN_TOOL_STATUS(
			"ERROR: UNKNOWN TOOL STATUS"), UNKNOWN_APP_STATUS(
			"ERROR: UNKNOWN APP STATUS"), AUTHENTICATION_ERROR(
			"ERROR: USER NOT AUTHENTICATED OR SESSION EXPIRED"), AUTHORIZATION_ERROR(
			"ERROR: USER NOT AUTHORIZED TO ACCESS THIS INFORMATION"), INVALID_COMMAND(
			"ERROR: INVALID COMMAND"), MISSING_FILE("ERROR: MISSING FILE"), FILE_ERROR(
			"ERROR: UNKNOWN FILE"), FILE_UPLOAD_ERROR(
			"ERROR: COULD NOT UPLOAD FILE"), FILE_NOT_FOUND(
			"ERROR: FILE NOT FOUND"), ERROR_SAVING_UPLOADED_FILE(
			"ERROR: COULD NOT SAVE UPLOADED FILE"), ILLEGAL_CHAR_IN_UPLOADED_FILENAME_ERROR(
			"ERROR: ILLEGAL CHAR OR SPACE IN FILENAME"), ERROR_APP_ALREADY_REGISTERED(
			"ERROR: APP ALREADY REGISTERED"), ANDROID_MANIFEST_ERROR(
			"ERROR: COULD NOT ACQUIRE ANDROID INFO FROM MANIFEST FILE"), IOS_METADATA_ERROR(
			"ERROR: COULD NOT ACQUIRE IOS METADATA"), MISSING_ANDROID_MANIFEST_ERROR(
			"ERROR: NO ANDROID MANIFEST FOUND"), MISSING_ANDROID_STRINGS_FILE_ERROR(
			"ERROR: NO ANDROID STRINGS RES FOUND"), ANDROID_APK_DECODE_ERROR(
			"ERROR: COULD NOT DECODE ANDROID APK"), TOOL_UNSUPPORTED_ENCODING_ERROR(
			"ERROR: UNSUPPORTED ENCODING ERROR"), TOOL_CLIENT_PROTOCOL_ERROR(
			"ERROR: CLIENT PROTOCOL ERROR"), URL_CONNECTION_ERROR(
			"ERROR: URL CONNECTION TIMED-OUT"), URL_SOCKET_TIMEOUT_ERROR(
			"ERROR: URL SOCKET TIMED-OUT WAITING FOR DATA"), TOOL_TIMEOUT_ERROR(
			"ERROR: TOOL TIMED-OUT"), REMOTE_SERVICE_ERROR(
			"ERROR: REMOTE SERVICE ISSUE"), INVALID_APP_OS(
			"ERROR: INVALID APP OS"), INVALID_APP_METADATA(
			"ERROR: INVALID OR MISSING APP METADATA");
	private String description;

	private ErrorMessage(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
