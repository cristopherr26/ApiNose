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
	USER_ERROR_SQL_EXCEPTION_FINDING_USER_WHILE_EXECUTION("Error durante la consulta de la información de un usuario", "Se ha presentado un problema tratando de ejecutar la consulta de la información de un usuario por favor intente de nuevo. Si el problema persiste por favor contacte al administrador del sistema"),
	TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_USER_WHILE_EXECUTION("Error SQL durante la operación de consulta de la información de un usuario", "Se ha presentado un problema de tipo SQLException durante la ejecución de la operación de consulta de la información de un usuario."),
	USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_USER_WHILE_EXECUTION("Error inesperado durante la consulta de la información de un usuario", "Se ha presentado un problema inesperado durante la ejecución operación de consulta de la información de un usuario. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema."),
	TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_USER_WHILE_EXECUTION("Error inesperado durante la operación de consulta de la información de un usuario", "Se ha presentado un problema inesperado durante la ejecución de la operación de consulta de la información de un usuario. No fue una SQLException, sino un error no controlado en el proceso de registro."),
	TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_USER_WHILE_PREPARATION("Error SQL durante la operación de consulta de la información de un usuario", "Se ha presentado un problema de tipo SQLException durante la preparacion de la sentencia sql para llevar a cabo la operación de consulta de la información de un usuario."),
	TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_USER_WHILE_PREPARATION("Error inesperado durante la operación de consulta de la información de un usuario", "Se ha presentado un problema inesperado durante la preparacipon de la sentencia sql de la operación de consulta de la información de un usuario. No fue una SQLException, sino un error no controlado en el proceso de registro."),
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
	TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_CITY("Error inesperado durante la operación de consulta de la información de una ciudad", "Se ha presentado un problema inesperado durante la operación de consulta de la información de una ciudad. No fue una SQLException, sino un error no controlado en el proceso de registro."),
	USER_ERROR_SQL_EXCEPTION_IDENTIFICATIONTYPE_MAPPER("Error al procesar la información del tipo de identificación", "Se ha presentado un problema al intentar mapear los datos del tipo de identificación desde la base de datos. Por favor, intente nuevamente. Si el problema persiste, contacte al administrador del sistema."),
	TECHNICAL_ERROR_SQL_EXCEPTION_IDENTIFICATION_TYPE_MAPPER("Error técnico al mapear el tipo de identificación", "Ocurrió un error técnico al intentar convertir los datos del tipo de identificación desde el ResultSet hacia la entidad IdentificationTypeEntity. Revise la estructura de las columnas o los alias definidos en la consulta SQL."),
	USER_ERROR_UNEXPECTED_EXCEPTION_IDENTIFICATIONTYPE_MAPPER("Error inesperado al procesar el tipo de identificación", "Se ha producido un error inesperado durante la conversión del tipo de identificación. Intente nuevamente o comuníquese con el administrador del sistema."),
	TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_IDENTIFICATIONTYPE_MAPPER("Error técnico inesperado al mapear el tipo de identificación","Se presentó una excepción no controlada durante el proceso de mapeo de la entidad IdentificationTypeEntity. Verifique posibles valores nulos o conversiones de tipo en el ResultSet."),
	USER_ERROR_SQL_EXCEPTION_COUNTRY_MAPPER("Error al procesar la información de un pais", "Se ha presentado un problema al intentar mapear los datos de un pais desde la base de datos. Por favor, intente nuevamente. Si el problema persiste, contacte al administrador del sistema."),
	TECHNICAL_ERROR_SQL_EXCEPTION_COUNTRY_MAPPER("Error técnico al mapear el pais", "Ocurrió un error técnico al intentar convertir los datos de un pais desde el ResultSet hacia la entidad CountryEntity. Revise la estructura de las columnas o los alias definidos en la consulta SQL."),
	USER_ERROR_UNEXPECTED_EXCEPTION_COUNTRY_MAPPER("Error inesperado al procesar el pais", "Se ha producido un error inesperado durante la conversión de un pais. Intente nuevamente o comuníquese con el administrador del sistema."),
	TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_COUNTRY_MAPPER("Error técnico inesperado al mapear el pais","Se presentó una excepción no controlada durante el proceso de mapeo de la entidad CountryEntity. Verifique posibles valores nulos o conversiones de tipo en el ResultSet."),
	USER_ERROR_SQL_EXCEPTION_STATE_MAPPER("Error al procesar la información de un departamento", "Se ha presentado un problema al intentar mapear los datos de un departamento desde la base de datos. Por favor, intente nuevamente. Si el problema persiste, contacte al administrador del sistema."),
	TECHNICAL_ERROR_SQL_EXCEPTION_STATE_MAPPER("Error técnico al mapear el departamento", "Ocurrió un error técnico al intentar convertir los datos de un departamento desde el ResultSet hacia la entidad StateEntity. Revise la estructura de las columnas o los alias definidos en la consulta SQL."),
	USER_ERROR_UNEXPECTED_EXCEPTION_STATE_MAPPER("Error inesperado al procesar un departamento", "Se ha producido un error inesperado durante la conversión de un departamento. Intente nuevamente o comuníquese con el administrador del sistema."),
	TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_STATE_MAPPER("Error técnico inesperado al mapear un departamento","Se presentó una excepción no controlada durante el proceso de mapeo de la entidad StateEntity. Verifique posibles valores nulos o conversiones de tipo en el ResultSet."),
	USER_ERROR_SQL_EXCEPTION_CITY_MAPPER("Error al procesar la información de una ciudad", "Se ha presentado un problema al intentar mapear los datos de una ciudad desde la base de datos. Por favor, intente nuevamente. Si el problema persiste, contacte al administrador del sistema."),
	TECHNICAL_ERROR_SQL_EXCEPTION_CITY_MAPPER("Error técnico al mapear una ciudad", "Ocurrió un error técnico al intentar convertir los datos de una ciudad desde el ResultSet hacia la entidad CityEntity. Revise la estructura de las columnas o los alias definidos en la consulta SQL."),
	USER_ERROR_UNEXPECTED_EXCEPTION_CITY_MAPPER("Error inesperado al procesar el tipo de identificación", "Se ha producido un error inesperado durante la conversión de una ciudad. Intente nuevamente o comuníquese con el administrador del sistema."),
	TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_CITY_MAPPER("Error técnico inesperado al mapear el tipo de identificación","Se presentó una excepción no controlada durante el proceso de mapeo de la entidad CityEntity. Verifique posibles valores nulos o conversiones de tipo en el ResultSet."),
	USER_ERROR_SQL_EXCEPTION_USER_MAPPER("Error al procesar la información del usuario", "Se ha presentado un problema al intentar mapear los datos del usuario desde la base de datos. Por favor, intente nuevamente. Si el problema persiste, contacte al administrador del sistema."),
	TECHNICAL_ERROR_SQL_EXCEPTION_USER_MAPPER("Error técnico al mapear el usuario", "Ocurrió un error técnico al intentar convertir los datos del usuario desde el ResultSet hacia la entidad UserEntity. Revise la estructura de las columnas o los alias definidos en la consulta SQL."),
	USER_ERROR_UNEXPECTED_EXCEPTION_USER_MAPPER("Error inesperado al procesar el usuario", "Se ha producido un error inesperado durante la conversión del usuario. Intente nuevamente o comuníquese con el administrador del sistema."),
	TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_USER_MAPPER("Error técnico inesperado al mapear el usuario","Se presentó una excepción no controlada durante el proceso de mapeo de la entidad UserEntity. Verifique posibles valores nulos o conversiones de tipo en el ResultSet."),
	
	USER_ERROR_WHILE_REGISTERING_USER_NULL_USER("La información del usuario es obligatoria", "No es posible registrar al usuario, ya que no se envió la informacion"),
	TECHNICAL_ERROR_WHILE_REGISTERING_USER_NULL_USER("UserDomain fue enviado como nulo", "No es posible registrar al usuario, ya que este fue enviado como null"),
	USER_ERROR_WHILE_REGISTERING_USER_NULL_IDENTIFICATION_TYPE("La información del tipo de documento del usuario es obligatoria", "No es posible registrar al usuario, ya que no se envió la informacion de su tipo de documento"),
	TECHNICAL_ERROR_WHILE_REGISTERING_USER_NULL_IDENTIFICATION_TYPE("identificationType fue enviado como nulo", "No es posible registrar al usuario, ya que su tipo de documento fue enviado como null"),
	USER_ERROR_WHILE_REGISTERING_USER_NULL_CITY("La información de la ciudad del usuario es obligatoria", "No es posible registrar al usuario, ya que no se envió la informacion de su ciudad de residencia"),
	TECHNICAL_ERROR_WHILE_REGISTERING_USER_NULL_CITY("residenceCity fue enviado como nulo", "No es posible registrar al usuario, ya que su ciudad de residencia fue enviado como null"),
	USER_ERROR_WHILE_REGISTERING_USER_INVALID_IDENTIFICATION_NUMBER("El número de documento no es válido", "No es posible registrar al usuario, ya que el número de documento no cumple con los parametros estipulados"),
	TECHNICAL_ERROR_WHILE_REGISTERING_USER_INVALID_IDENTIFICATION_NUMBER("El número de documento no es válido", "No es posible registrar al usuario, ya que EL número de documento fue enviado vacío o supera los 25 caracteres"),
	USER_ERROR_WHILE_REGISTERING_USER_INVALID_FIRST_NAME("El primer nombre del usuario no es válido", "No es posible registrar al usuario, ya que el primer nombre no cumple con los parametros estipulados"),
	TECHNICAL_ERROR_WHILE_REGISTERING_USER_INVALID_FIRST_NAME("El primer nombre del usuario no es válido", "No es posible registrar al usuario, ya que su primer nombre fue enviado vacío o supera los 20 caracteres"),
	USER_ERROR_WHILE_REGISTERING_USER_INVALID_MIDDLE_NAME("El segundo nombre del usuario no es válido", "No es posible registrar al usuario, ya que su segundo nombre no cumple con los parametros estipulados"),
	TECHNICAL_ERROR_WHILE_REGISTERING_USER_INVALID_MIDDLE_NAME("El segundo nombre del usuario no es válido", "No es posible registrar al usuario, ya que su segundo nombre fue enviado vacío o supera los 20 caracteres"),
	USER_ERROR_WHILE_REGISTERING_USER_INVALID_LAST_NAME("El primer apellido del usuario no es válido", "No es posible registrar al usuario, ya que el primer apellido del usuario no cumple con los parametros estipulados"),
	TECHNICAL_ERROR_WHILE_REGISTERING_USER_INVALID_lAST_NAME("El primer apellido del usuario no es válido", "No es posible registrar al usuario, ya que primer apellido del usuario fue enviado vacío o supera los 20 caracteres"),
	USER_ERROR_WHILE_REGISTERING_USER_INVALID_SECOND_LAST_NAME("El segundo apellido del usuario no es válido", "No es posible registrar al usuario, ya que el segundo apellido del usuario no cumple con los parametros estipulados"),
	TECHNICAL_ERROR_WHILE_REGISTERING_USER_INVALID_SECOND_lAST_NAME("El segundo apellido del usuario no es válido", "No es posible registrar al usuario, ya que el segundo apellido del usuario fue enviado vacío o supera los 20 caracteres"),
	USER_ERROR_WHILE_REGISTERING_USER_INVALID_EMAIL("El email del usuario no es válido", "No es posible registrar al usuario, ya que su email no cumple con los parametros estipulados"),
	TECHNICAL_ERROR_WHILE_REGISTERING_USER_INVALID_EMAIL("El email del usuario no es válido", "No es posible registrar al usuario, ya que su email fue enviado vacío, supera los 250 caracteres o no cumple el formato estipulado"),
	USER_ERROR_WHILE_REGISTERING_USER_INVALID_CELL_PHONE_NUMBER("El teléfono del usuario no es válido", "No es posible registrar al usuario, ya que el teléfono del usuario no cumple con los parametros estipulados"),
	TECHNICAL_ERROR_WHILE_REGISTERING_USER_INVALID_CELL_PHONE_NUMBER("El teléfono del usuario no es válido", "No es posible registrar al usuario, ya que el teléfono del usuario fue enviado vacío, no cumple el formato estipulado o supera los 20 caracteres"),
	USER_ERROR_WHILE_REGISTERING_USER_DUPLICATED_CELL_PHONE_NUMBER("El número de teléfono ya se encuentra registrado", "No es posible registrar al usuario, ya que el teléfono ingresado por el usuario ya se encuentra en uso"),
	TECHNICAL_ERROR_WHILE_REGISTERING_USER_DUPLICATED_CELL_PHONE_NUMBER("El número de teléfono ya se encuentra registrado", "No es posible registrar al usuario, ya que el teléfono ingresado por el uusario ya se encuentra registrado dentro de la fuente de datos"),
	USER_ERROR_WHILE_REGISTERING_USER_DUPLICATED_IDENTIFICATION("El tipo y número de documento del usuario ya se encuentra registrado", "No es posible registrar al usuario, ya que el tipo de documento y el número de documento ingresado por el usuario ya se encuentra en uso"),
	TECHNICAL_ERROR_WHILE_REGISTERING_USER_DUPLICATED_IDENTIFICATION("El tipo y número de documento del usuario ya se encuentra registrado", "No es posible registrar al usuario, ya que el tipo y número de documento del usuario ya se encuentra registrado dentro de la fuente de datos"),
	USER_ERROR_WHILE_REGISTERING_USER_DUPLICATED_EMAIL("El correo electrónico ya se encuentra registrado", "No es posible registrar al usuario, ya que el correo electrónico ingresado por el usuario ya se encuentra en uso"),
	TECHNICAL_ERROR_WHILE_REGISTERING_USER_DUPLICATED_EMAIL("El correo electrónico ya se encuentra registrado", "No es posible registrar al usuario, ya que el correo electrónico ingresado por el uusario ya se encuentra registrado dentro de la fuente de datos");
	

	
	
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
