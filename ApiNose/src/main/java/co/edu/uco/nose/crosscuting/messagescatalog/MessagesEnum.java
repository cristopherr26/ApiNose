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
	USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_NOT_STARTED("Error inesperado tratando de validar el estado de la operacion deseada frente a la fuente de informacion se encontraba activado", "Ocurrió un problema inesperado al validar si la operación solicitada contra la fuente de información deseada estaba iniciada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	USER_ERROR_FACTORY_NOT_INITIALIZED("Factoria no iniciada", "La fuente de información sobre la cual se va a realizar la transacción seleccionada no esta disponible dentro del sistema. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	TECHNICAL_ERROR_FACTORY_NOT_VALIDATED("Factotoria no validada", "La factoria de acceso a datos no existe y por tanto no se puede determinar a que fuente de datos debe conectarse."),
	USER_ERROR_SQL_EXCEPTION_REGISTERING_USER("Error durante el registro de un usuario", "Se ha presentado un problema tratando de registrar la información del nuevo usuario por favor intente de nuevo. Si el problema persiste por favor contacte al administrador del sistema"),
	TECHNICAL_ERROR_SQL_EXCEPTION_REGISTERING_USER("Error SQL durante la operación de registro de un nuevo usuario", "Se ha presentado un problema de tipo SQLException durante la operación de registro de un nuevo usuario."),
	USER_ERROR_UNEXPECTED_EXCEPTION_REGISTERING_USER("Error inesperado durante el registro de un nuevo usuario", "Se ha presentado un problema inesperado durante la operación de registro de un nuevo usuario. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema."),
	TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_REGISTERING_USER("Error inesperado durante la operación de registro de un nuevo usuario", "Se ha presentado un problema inesperado durante la operación de registro de un nuevo usuario. No fue una SQLException, sino un error no controlado en el proceso de registro."),
	USER_ERROR_SQL_EXCEPTION_UPDATING_USER("Error durante la actualización de la información de un usuario", "Se ha presentado un problema tratando de actualizar la información de un usuario por favor intente de nuevo. Si el problema persiste por favor contacte al administrador del sistema"),
	TECHNICAL_ERROR_SQL_EXCEPTION_UPDATING_USER("Error SQL durante la operación de actualización de la información de un usuario", "Se ha presentado un problema de tipo SQLException durante la operación de actualización de la información de un usuario."),
	USER_ERROR_UNEXPECTED_EXCEPTION_UPDATING_USER("Error inesperado durante la actualización de la información de un usuario", "Se ha presentado un problema inesperado durante la operación de actualización de la información de un usuario. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema."),
	TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_UPDATING_USER("Error inesperado durante la operación de actualización de la información de un usuario", "Se ha presentado un problema inesperado durante la operación de actualización de la información de un usuario. No fue una SQLException, sino un error no controlado en el proceso de registro."),
	USER_ERROR_SQL_EXCEPTION_DELETING_USER("Error durante la elminación de un usuario", "Se ha presentado un problema tratando de eliminar un usuario por favor intente de nuevo. Si el problema persiste por favor contacte al administrador del sistema"),
	TECHNICAL_ERROR_SQL_EXCEPTION_DELETING_USER("Error SQL durante la operación de eliminación de un usuario", "Se ha presentado un problema de tipo SQLException durante la operación de eliminación de un usuario."),
	USER_ERROR_UNEXPECTED_EXCEPTION_DELETING_USER("Error inesperado durante la eliminación de un usuario", "Se ha presentado un problema inesperado durante la operación de eliminación de un usuario. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema."),
	TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_DELETING_USER("Error inesperado durante la operación de eliminación de un usuario", "Se ha presentado un problema inesperado durante la operación de eliminación de un usuario. No fue una SQLException, sino un error no controlado en el proceso de registro."),
	USER_ERROR_SQL_EXCEPTION_FINDING_USER("Error durante la consulta de la información de un usuario", "Se ha presentado un problema tratando de consulta de la información de un usuario por favor intente de nuevo. Si el problema persiste por favor contacte al administrador del sistema"),
	TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_USER("Error SQL durante la operación de consulta de la información de un usuario", "Se ha presentado un problema de tipo SQLException durante la operación de consulta de la información de un usuario."),
	USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_USER("Error inesperado durante la consulta de la información de un usuario", "Se ha presentado un problema inesperado durante la operación de consulta de la información de un usuario. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema."),
	TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_USER("Error inesperado durante la operación de consulta de la información de un usuario", "Se ha presentado un problema inesperado durante la operación de consulta de la información de un usuario. No fue una SQLException, sino un error no controlado en el proceso de registro."),
	USER_ERROR_SQL_EXCEPTION_FINDING_IDENTIFICATIONTYPE("Error durante la consulta de la información de un tipo de documento", "Se ha presentado un problema tratando de consulta de la información de un tipo de documento por favor intente de nuevo. Si el problema persiste por favor contacte al administrador del sistema"),
	TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_IDENTIFICATIONTYPE("Error SQL durante la operación de consulta de la información de un tipo de documento", "Se ha presentado un problema de tipo SQLException durante la operación de consulta de la información de un tipo de documento."),
	USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_IDENTIFICATIONTYPE("Error inesperado durante la consulta de la información de un tipo de documento", "Se ha presentado un problema inesperado durante la operación de consulta de la información de un tipo de documento. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema."),
	TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_IDENTFICATIONTYPE("Error inesperado durante la operación de consulta de la información de un tipo de documento", "Se ha presentado un problema inesperado durante la operación de consulta de la información de un tipo de documento. No fue una SQLException, sino un error no controlado en el proceso de registro."),
	USER_ERROR_SQL_EXCEPTION_FINDING_COUNTRY("Error durante la consulta de la información de un pais", "Se ha presentado un problema tratando de consulta de la información de un pais por favor intente de nuevo. Si el problema persiste por favor contacte al administrador del sistema"),
	TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_COUNTRY("Error SQL durante la operación de consulta de la información de un pais", "Se ha presentado un problema de tipo SQLException durante la operación de consulta de la información de un pais."),
	USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_COUNTRY("Error inesperado durante la consulta de la información de un pais", "Se ha presentado un problema inesperado durante la operación de consulta de la información de un pais. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema."),
	TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_COUNTRY("Error inesperado durante la operación de consulta de la información de un pais", "Se ha presentado un problema inesperado durante la operación de consulta de la información de un pais. No fue una SQLException, sino un error no controlado en el proceso de registro."),
	USER_ERROR_SQL_EXCEPTION_FINDING_STATE("Error durante la consulta de la información de un departamento", "Se ha presentado un problema tratando de consulta de la información de un departamento por favor intente de nuevo. Si el problema persiste por favor contacte al administrador del sistema"),
	TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_STATE("Error SQL durante la operación de consulta de la información de un departamento", "Se ha presentado un problema de tipo SQLException durante la operación de consulta de la información de un departamento."),
	USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_STATE("Error inesperado durante la consulta de la información de un departamento", "Se ha presentado un problema inesperado durante la operación de consulta de la información de un departamento. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema."),
	TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_STATE("Error inesperado durante la operación de consulta de la información de un departamento", "Se ha presentado un problema inesperado durante la operación de consulta de la información de un departamento. No fue una SQLException, sino un error no controlado en el proceso de registro."),
	USER_ERROR_SQL_EXCEPTION_FINDING_CITY("Error durante la consulta de la información de una ciudad", "Se ha presentado un problema tratando de consulta de la información de una ciudad por favor intente de nuevo. Si el problema persiste por favor contacte al administrador del sistema"),
	TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_CITY("Error SQL durante la operación de consulta de la información de una ciudad", "Se ha presentado un problema de tipo SQLException durante la operación de consulta de la información de una ciudad."),
	USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_CITY("Error inesperado durante la consulta de la información de una ciudad", "Se ha presentado un problema inesperado durante la operación de consulta de la información de una ciudad. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema."),
	TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_CITY("Error inesperado durante la operación de consulta de la información de una ciudad", "Se ha presentado un problema inesperado durante la operación de consulta de la información de una ciudad. No fue una SQLException, sino un error no controlado en el proceso de registro.");
	
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
