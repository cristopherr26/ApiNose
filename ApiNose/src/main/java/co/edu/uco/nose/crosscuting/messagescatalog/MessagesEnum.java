package co.edu.uco.nose.crosscuting.messagescatalog;

import co.edu.uco.nose.crosscuting.helper.TextHelper;

public enum MessagesEnum {
	
	USER_ERROR_SQL_CONNECTION_IS_EMPTY("Conexión contra la fuente de información deseada vacía", "La conexión requerida para llevar a cabo la operación contra la fuente de información deseada esta vacía. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación"),
	TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY("Conexión contra la fuente de información deseada nula", "La conexión requerida para llevar a cabo la operación contra la base de datos llegó nula." ),
	USER_ERROR_SQL_CONNECTION_IS_CLOSED("Conexión contra la fuente de información deseada cerrada", "La conexión requerida para llevar a cabo la operación contra la fuente de información deseada esta cerrada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación"),
	TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED("Conexión contra la fuente de información deseada cerrada", "La conexión requerida para llevar a cabo la operación contra la base de datos llegó cerrada." ),
	USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Problema inesperado validando el estado de la conexión contra la fuente de datos deseada ", "Se ha presentado un problema inesperado tratando de validar el estado de la conexión requerida para llevar a cabo la operación contra la fuente de información deseada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación"),
	TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Error inesperado validando si la conexión contra la base de datos estaba abierta", "Se presento un error de tipo SQLException al validar si la conexión contra base de datos estaba o no abierta." ),
	USER_ERROR_TRANSACTION_IS_NOT_STARTED("Manejo de operaciones frente a la fuente de información deseada no ha sido iniciado", "No se ha iniciado el manejo de operaciones frente a la fuente de información para ejecutar la operación solicitada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	TECHNICAL_ERROR_TRANSACTION_IS_NOT_STARTED("El autocommit contra la fuente de información deseada se encuentra activado", "El autocommit requerido para llevar a cabo la operación contra la base de datos se encuentra activado."),
	USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_STARTED("Error inesperado validando el estado de la operación deseada frente a la fuente de información", "Ocurrió un problema inesperado al validar si la operación solicitada contra la fuente de información deseada estaba iniciada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_NOT_STARTED("Error SQL validando si la transacción no estaba iniciada", "Se presentó un error de tipo SQLException mientras se verificaba si la transacción en la conexión con la base de datos no había sido iniciada."),
	TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_CONNECTION_STATUS("Error SQL validando el estado de la conexión contra la base de datos", "Se presentó una excepción de tipo SQLException al intentar validar si la conexión contra la base de datos se encontraba activa o disponible."),
	TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_NOT_STARTED( "Error inesperado validando si la transacción no estaba iniciada",  "Se presentó un problema inesperado al intentar validar si la transacción contra la base de datos no había sido iniciada. No fue una SQLException, sino un error no controlado en el proceso de validación."),
	TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_STARTED("Error SQL validando si la transacción estaba iniciada", "Se presentó un error de tipo SQLException mientras se verificaba si la transacción en la conexión con la base de datos había sido iniciada."),
	TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_STARTED( "Error inesperado validando si la transacción estaba iniciada",  "Se presentó un problema inesperado al intentar validar si la transacción contra la base de datos había sido iniciada. No fue una SQLException, sino un error no controlado en el proceso de validación."),
	TECHNICAL_ERROR_TRANSACTION_IS_STARTED("El autocommit contra la fuente de información deseada se encuentra desactivado", "El autocommit requerido para llevar a cabo la operación contra la base de datos se encuentra desactivado."),
	USER_ERROR_TRANSACTION_IS_STARTED("Manejo de operaciones frente a la fuente de información deseada ha sido iniciado", "Ya se encuentra iniciado el manejo de operaciones frente a la fuente de información para ejecutar la operación solicitada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_NOT_STARTED("Error inesperado tratando de validar el estado de la operacion deseada frente a la fuente de informacion se encontraba activado", "Ocurrió un problema inesperado al validar si la operación solicitada contra la fuente de información deseada estaba iniciada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación.");
	
	private String title;
	private String content;
	
	
	private MessagesEnum(final String title, final String content) {
		setTitle(title);
		setContent(content);
	}


	public String getTitle() {
		return title;
	}


	private void setTitle(final String title) {
		this.title = TextHelper.getDefaultWithTrim(title);
	}


	public String getContent() {
		return content;
	}


	private void setContent(final String content) {
		this.content = TextHelper.getDefaultWithTrim(content);
	}
	
	
	
	

}
