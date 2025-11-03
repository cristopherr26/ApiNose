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
	USER_ERROR_SQL_EXCEPTION_FINDING_IDENTIFICATION_TYPE_WHILE_EXECUTION("Error durante la consulta de la información de un tipo de documento", "Se ha presentado un problema tratando de ejecutar la consulta de la información de un tipo de documento por favor intente de nuevo. Si el problema persiste por favor contacte al administrador del sistema"),
	TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_IDENTIFICATION_TYPE_WHILE_EXECUTION("Error SQL durante la operación de consulta de la información de un tipo de documento", "Se ha presentado un problema de tipo SQLException durante la ejecución de la operación de consulta de la información de un tipo de documento."),
	USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_IDENTIFICATION_TYPE_WHILE_EXECUTION("Error inesperado durante la consulta de la información de un tipo de documento", "Se ha presentado un problema inesperado durante la ejecución operación de consulta de la información de un tipo de documento. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema."),
	TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_IDENTIFICATION_TYPE_WHILE_EXECUTION("Error inesperado durante la operación de consulta de la información de un tipo de documento", "Se ha presentado un problema inesperado durante la ejecución de la operación de consulta de la información de un tipo de documento. No fue una SQLException, sino un error no controlado en el proceso de registro."),
	TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_IDENTIFICATION_TYPE_WHILE_PREPARATION("Error SQL durante la operación de consulta de la información de un tipo de documento", "Se ha presentado un problema de tipo SQLException durante la preparacion de la sentencia sql para llevar a cabo la operación de consulta de la información de un tipo de documento."),
	TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_IDENTIFICATION_TYPE_WHILE_PREPARATION("Error inesperado durante la operación de consulta de la información de un tipo de documento", "Se ha presentado un problema inesperado durante la preparacipon de la sentencia sql de la operación de consulta de la información de un tipo de documento. No fue una SQLException, sino un error no controlado en el proceso de registro."),
	USER_ERROR_SQL_EXCEPTION_FINDING_COUNTRY_WHILE_EXECUTION("Error durante la consulta de la información de un pais", "Se ha presentado un problema tratando de ejecutar la consulta de la información de un pais por favor intente de nuevo. Si el problema persiste por favor contacte al administrador del sistema"),
	TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_COUNTRY_WHILE_EXECUTION("Error SQL durante la operación de consulta de la información de un pais", "Se ha presentado un problema de tipo SQLException durante la ejecución de la operación de consulta de la información de un pais."),
	USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_COUNTRY_WHILE_EXECUTION("Error inesperado durante la consulta de la información de un pais", "Se ha presentado un problema inesperado durante la ejecución operación de consulta de la información de un pais. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema."),
	TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_COUNTRY_WHILE_EXECUTION("Error inesperado durante la operación de consulta de la información de un pais", "Se ha presentado un problema inesperado durante la ejecución de la operación de consulta de la información de un pais. No fue una SQLException, sino un error no controlado en el proceso de registro."),
	TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_COUNTRY_WHILE_PREPARATION("Error SQL durante la operación de consulta de la información de un pais", "Se ha presentado un problema de tipo SQLException durante la preparacion de la sentencia sql para llevar a cabo la operación de consulta de la información de un pais."),
	TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_COUNTRY_WHILE_PREPARATION("Error inesperado durante la operación de consulta de la información de un pais", "Se ha presentado un problema inesperado durante la preparacipon de la sentencia sql de la operación de consulta de la información de un pais. No fue una SQLException, sino un error no controlado en el proceso de registro."),
	USER_ERROR_SQL_EXCEPTION_FINDING_STATE_WHILE_EXECUTION("Error durante la consulta de la información de un departamento", "Se ha presentado un problema tratando de ejecutar la consulta de la información de un departamento por favor intente de nuevo. Si el problema persiste por favor contacte al administrador del sistema"),
	TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_STATE_WHILE_EXECUTION("Error SQL durante la operación de consulta de la información de un departamento", "Se ha presentado un problema de tipo SQLException durante la ejecución de la operación de consulta de la información de un departamento."),
	USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_STATE_WHILE_EXECUTION("Error inesperado durante la consulta de la información de un departamento", "Se ha presentado un problema inesperado durante la ejecución operación de consulta de la información de un departamento. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema."),
	TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_STATE_WHILE_EXECUTION("Error inesperado durante la operación de consulta de la información de un departamento", "Se ha presentado un problema inesperado durante la ejecución de la operación de consulta de la información de un departamento. No fue una SQLException, sino un error no controlado en el proceso de registro."),
	TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_STATE_WHILE_PREPARATION("Error SQL durante la operación de consulta de la información de un departamento", "Se ha presentado un problema de tipo SQLException durante la preparacion de la sentencia sql para llevar a cabo la operación de consulta de la información de un departamento."),
	TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_STATE_WHILE_PREPARATION("Error inesperado durante la operación de consulta de la información de un departamento", "Se ha presentado un problema inesperado durante la preparacipon de la sentencia sql de la operación de consulta de la información de un departamento. No fue una SQLException, sino un error no controlado en el proceso de registro."),
	USER_ERROR_SQL_EXCEPTION_FINDING_CITY_WHILE_EXECUTION("Error durante la consulta de la información de una ciudad", "Se ha presentado un problema tratando de ejecutar la consulta de la información de una ciudad por favor intente de nuevo. Si el problema persiste por favor contacte al administrador del sistema"),
	TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_CITY_WHILE_EXECUTION("Error SQL durante la operación de consulta de la información de una ciudad", "Se ha presentado un problema de tipo SQLException durante la ejecución de la operación de consulta de la información de una ciudad."),
	USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_CITY_WHILE_EXECUTION("Error inesperado durante la consulta de la información de una ciudad", "Se ha presentado un problema inesperado durante la ejecución operación de consulta de la información de una ciudad. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema."),
	TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_CITY_WHILE_EXECUTION("Error inesperado durante la operación de consulta de la información de una ciudad", "Se ha presentado un problema inesperado durante la ejecución de la operación de consulta de la información de una ciudad. No fue una SQLException, sino un error no controlado en el proceso de registro."),
	TECHNICAL_ERROR_SQL_EXCEPTION_FINDING_CITY_WHILE_PREPARATION("Error SQL durante la operación de consulta de la información de una ciudad", "Se ha presentado un problema de tipo SQLException durante la preparacion de la sentencia sql para llevar a cabo la operación de consulta de la información de una ciudad."),
	TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_CITY_WHILE_PREPARATION("Error inesperado durante la operación de consulta de la información de una ciudad", "Se ha presentado un problema inesperado durante la preparacipon de la sentencia sql de la operación de consulta de la información de una ciudad. No fue una SQLException, sino un error no controlado en el proceso de registro."),

	
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
	TECHNICAL_ERROR_WHILE_REGISTERING_USER_DUPLICATED_EMAIL("El correo electrónico ya se encuentra registrado", "No es posible registrar al usuario, ya que el correo electrónico ingresado por el uusario ya se encuentra registrado dentro de la fuente de datos"),
	USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_USER("Error inesperado durante la consulta de la información de un usuario", "Se ha presentado un problema inesperado durante la operación de consulta de la información de un usuario. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema."),
	TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_USER("Error inesperado durante la operación de consulta de la información de un usuario", "Se ha presentado un problema inesperado durante la de la operación de consulta de la información de un usuario. No fue una SQLException, sino un error no controlado en el proceso de consulta."),
	USER_ERROR_WHILE_UPDATING_USER_DUPLICATED_CELL_PHONE_NUMBER("El número de teléfono ya se encuentra registrado", "No es posible actualizar la información al usuario, ya que el teléfono ingresado por el usuario ya se encuentra en uso"),
	TECHNICAL_ERROR_WHILE_UPDATING_USER_DUPLICATED_CELL_PHONE_NUMBER("El número de teléfono ya se encuentra registrado", "No es posible actualizar la información al usuario, ya que el teléfono ingresado por el uusario ya se encuentra registrado dentro de la fuente de datos"),
	USER_ERROR_WHILE_UPDATING_USER_DUPLICATED_IDENTIFICATION("El tipo y número de documento del usuario ya se encuentra registrado", "No es posible actualizar la información al usuario, ya que el tipo de documento y el número de documento ingresado por el usuario ya se encuentra en uso"),
	TECHNICAL_ERROR_WHILE_UPDATING_USER_DUPLICATED_IDENTIFICATION("El tipo y número de documento del usuario ya se encuentra registrado", "No es posible actualizar la información al usuario, ya que el tipo y número de documento del usuario ya se encuentra registrado dentro de la fuente de datos"),
	USER_ERROR_WHILE_UPDATING_USER_DUPLICATED_EMAIL("El correo electrónico ya se encuentra registrado", "No es posible actualizar la información al usuario, ya que el correo electrónico ingresado por el usuario ya se encuentra en uso"),
	TECHNICAL_ERROR_WHILE_UPDATING_USER_DUPLICATED_EMAIL("El correo electrónico ya se encuentra registrado", "No es posible actualizar la información al usuario, ya que el correo electrónico ingresado por el uusario ya se encuentra registrado dentro de la fuente de datos"),

	USER_SUCESSFULLY_REGISTERED("El Usuario fue registrado con éxito", "El Registro del usuario se llevo a cabo con éxito"),
	USER_SUCESSFULLY_UPDATED("El Usuario fue actualizado con éxito", "La actualización del usuario se llevo a cabo con éxito"),
	USER_SUCESSFULLY_DELETED("El Usuario fue eliminado con éxito", "La eliminación del usuario se llevo a cabo con éxito"),
	USER_SUCESSFULLY_FOUND("El Usuario O los usuarios fueron consultados con éxito", "La consulta del usuario o los usuarios se llevo a cabo con éxito"),
	
	
	USER_ERROR_TRYING_TO_MAKE_AN_OPERATION("Error tratando de llevar a cabo la operación", "Se ha presentado un error tratando de llevar a cabo la operación esperada"),
	TECHNICAL_ERROR_VALUE_IS_NOT_PRESENT("Error tratando de llevar a cabo la operación", "No se recibieron los parametros requeridos para ejecutar la regla StringIsPresentRule"),
	TECHNICAL_ERROR_STRING_LENGTH_VALUE("Error tratando de llevar a cabo la operación", "No se recibieron los parametros requeridos para ejecutar la regla StringLengthValueIsValidRule"),
	TECHNICAL_ERROR_STRING_FORMAT_VALUE("Error tratando de llevar a cabo la operación", "No se recibieron los parametros requeridos para ejecutar la regla StringFormatValueIsValidRule"),
	TECHNICAL_ERROR_WRONG_STRING_LENGTH_VALUE("No fueron ingresados todos los parametros", "Se requerían 5 parametros y llegó una cantidad menor a esta requeridos para ejecutar la regla StringLengthValueIsValidRule"),
	TECHNICAL_ERROR_WRONG_STRING_FORMAT_VALUE("No fueron ingresados todos los parametros", "Se requerían 4 parametros y llegó una cantidad menor a esta requeridos para ejecutar la regla StringFormatValueIsValidRule"),
	
	TECHNICAL_ERROR_VALUE_UUID_IS_NOT_PRESENT("Error tratando de llevar a cabo la operación", "No se recibieron los parametros requeridos para ejecutar la regla UuidValueIsPresentRule"),
	TECHNICAL_ERROR_WRONG_UUID_LENGTH_IS_NOT_PRESENT("No fueron ingresados todos los parametros", "Se requerían 2 parametros y llegó una cantidad menor a esta requeridos para ejecutar la regla UuidValueIsPresentRule"),
	TECHNICAL_ERROR_UUID_IS_DEFAULT("UUID por defecto", "La operacion no pudo ser llevada a cabo, ya que en el el siguiente dato fue ingresado el uuid por defecto: "),
	
	TECHNICAL_ERROR_VALUE_USER_IS_NOT_PRESENT("Error tratando de llevar a cabo la operación", "No se recibieron los parametros requeridos para ejecutar el validator ValidateDataUserConsistencyForRegisterNewInformation"),
	TECHNICAL_ERROR_WRONG_USER_LENGTH_VALUE_IS_NOT_PRESENT("No fueron ingresados todos los parametros", "Se requería 1 parametro y llegó una cantidad menor a esta requerida para ejecutar el validator ValidateDataUserConsistencyForRegisterNewInformation"),

	
	TECHNICAL_ERROR_VALUE_UUID_IS_NOT_DEFAULT("Error tratando de llevar a cabo la operación", "No se recibieron los parametros requeridos para ejecutar la regla IdValueIsNotDefaultValueRule"),
	TECHNICAL_ERROR_WRONG_UUID_LENGTH_IS_NOT_DEFAULT("No fueron ingresados todos los parametros", "Se requerían 2 parametros y llegó una cantidad menor a esta requeridos para ejecutar la regla IdValueIsNotDefaultValueRule"),

	TECHNICAL_ERROR_WRONG_STRING_LENGTH_IS_PRESENT("No fueron ingresados todos los parametros", "Se requerían 3 parametros y llegó una cantidad menor a esta requeridos para ejecutar la regla StringIsPresentRule"),
	USER_ERROR_WRONG_LENGTH("El dato ingresado tiene una longitud incorrecta",  "El siguiente dato debe tener una longituda de: " ),
	TECHNICAL_ERROR_WRONG_LENGTH("El dato ingresado tiene una longitud incorrecta", "La regla StringLengthValueIsValidRule fallo ya que el siguiente dato debe tener la siguiente longitud: "),
	USER_ERROR_INCOMPLETE_PARAMETERS("No se enviaron todos los datos necesarios", "El dato es necesario para llevar a cabo la operación: "),
	TECHNICAL_ERROR_INCOMPLETE_PARAMETERS("No se enviaron todos los datos necesarios", "La regla StringValueIsPresent falló porque el siguiente dato requerido para llevar a cabo la operación está vacío: "),
	
	USER_ERROR_WRONG_FORMAT("El dato ingresado tiene un formato incorrecto",  "El siguiente dato NO cumple con los caracteres estipulados para este campo: " ),
	TECHNICAL_ERROR_WRONG_FORMAT("El dato ingresado tiene un formato incorrecto", "La regla StringFormatValueIsValidRule fallo ya que el siguiente dato debe contener solo los siguientes caracteres:  "),
	
	TECHNICAL_ERROR_VALUE_IS_NOT_PRESENT_IDENTIFICATION_TYPE("Error tratando de llevar a cabo la operación", "No se recibieron los parametros requeridos para ejecutar la regla IdentificationTypeExistsByIdRule"),
	TECHNICAL_ERROR_WRONG_IDENTIFICATION_TYPE_LENGTH_VALUE("No fueron ingresados todos los parametros", "Se requerían 2 parametros y llegó una cantidad menor a esta requeridos para ejecutar la regla IdentificationTypeExistsByIdRule"),
	USER_ERROR_IDENTIFICATION_TYPE_DOES_NOT_EXITS("El tipo de documento no existe", "El tipo de documento ingresado no existe"),
	TECHNICAL_ERROR_IDENTIFICATION_TYPE_DOES_NOT_EXITS("El tipo de documento no existe", "El tipo de documento con el siguiente id no existe: "),
	
	TECHNICAL_ERROR_VALUE_IS_NOT_PRESENT_CITY("Error tratando de llevar a cabo la operación", "No se recibieron los parametros requeridos para ejecutar la regla CityExistsByIdRule"),
	TECHNICAL_ERROR_WRONG_CITY_LENGTH_VALUE("No fueron ingresados todos los parametros", "Se requerían 2 parametros y llegó una cantidad menor a esta requeridos para ejecutar la regla CityExistsByIdRule"),
	USER_ERROR_CITY_DOES_NOT_EXITS("La ciudad no existe", "La ciudad ingresada no existe"),
	TECHNICAL_ERROR_CITY_DOES_NOT_EXITS("La ciudad no existe", "La ciudad con el siguiente id no existe: "),
	
	TECHNICAL_ERROR_VALUE_IS_NOT_PRESENT_USER("Error tratando de llevar a cabo la operación", "No se recibieron los parametros requeridos para ejecutar la regla UserExistsByIdRule"),
	TECHNICAL_ERROR_WRONG_USER_LENGTH_VALUE("No fueron ingresados todos los parametros", "Se requerían 2 parametros y llegó una cantidad menor a esta requeridos para ejecutar la regla UserExistsByIdRule"),
	USER_ERROR_USER_DOES_NOT_EXITS("El usuario no existe", "El usuario ingresada no existe"),
	TECHNICAL_ERROR_USER_DOES_NOT_EXITS("El usuario no existe", "El usuario con el siguiente id no existe: "),
	
	TECHNICAL_ERROR_VALUE_USER_DOES_NOT_EXISTS_BY_IDENTIFICATION("Error tratando de llevar a cabo la operación", "No se recibieron los parametros requeridos para ejecutar la regla UserDoesNotExistsWithSameIdtypeAndNumberRule"),
	TECHNICAL_ERROR_WRONG_USER_LENGTH_VALUE_USER_DOES_NOT_EXISTS_BY_IDENTIFICATION("No fueron ingresados todos los parametros", "Se requerían 3 parametros y llegó una cantidad menor a esta requeridos para ejecutar la regla UserDoesNotExistsWithSameIdtypeAndNumberRule"),
	USER_ERROR_USER_DOES_EXISTS_BY_IDENTIFICATION("Ya hay un usuario registrado con ese tipo y número de identificación", "No es posible llevar a cabo la operación, ya que ya existe un usuario con el mismo tipo y número de identificación"),
	TECHNICAL_ERROR_USER_DOES_EXISTS_BY_IDENTIFICATION("Ya hay un usuario registrado con ese tipo y número de identificación", "No es posible llevar a cabo la operación, ya que ya existe un usuario dentro de la fuente de datos con el mismo tipo y número de identificación "),
	
	TECHNICAL_ERROR_VALUE_USER_DOES_NOT_EXISTS_BY_EMAIL("Error tratando de llevar a cabo la operación", "No se recibieron los parametros requeridos para ejecutar la regla UserEmailDoesNotExistsRule"),
	TECHNICAL_ERROR_WRONG_USER_LENGTH_VALUE_USER_DOES_NOT_EXISTS_BY_EMAIL("No fueron ingresados todos los parametros", "Se requerían 2 parametros y llegó una cantidad menor a esta requeridos para ejecutar la regla UserEmailDoesNotExistsRule"),
	USER_ERROR_USER_DOES_EXISTS_BY_EMAIL("Ya hay un usuario registrado con ese email", "No es posible llevar a cabo la operación, ya que ya existe un usuario con el email"),
	TECHNICAL_ERROR_USER_DOES_EXISTS_BY_EMAIL("Ya hay un usuario registrado con ese email", "No es posible llevar a cabo la operación, ya que ya existe un usuario dentro de la fuente de datos con el mismo email "),
	
	TECHNICAL_ERROR_VALUE_USER_DOES_NOT_EXISTS_BY_MOBILE_NUMBER("Error tratando de llevar a cabo la operación", "No se recibieron los parametros requeridos para ejecutar la regla UserEmailDoesNotExistsRule"),
	TECHNICAL_ERROR_WRONG_USER_LENGTH_VALUE_USER_DOES_NOT_EXISTS_BY_MOBILE_NUMBER("No fueron ingresados todos los parametros", "Se requerían 2 parametros y llegó una cantidad menor a esta requeridos para ejecutar la regla UserEmailDoesNotExistsRule"),
	USER_ERROR_USER_DOES_EXISTS_BY_MOBILE_NUMBER("Ya hay un usuario registrado con ese número de teléfono", "No es posible llevar a cabo la operación, ya que ya existe un usuario con el mismo  número de teléfono"),
	TECHNICAL_ERROR_USER_DOES_EXISTS_BY_MOBILE_NUMBER("Ya hay un usuario registrado con ese  número de teléfono", "No es posible llevar a cabo la operación, ya que ya existe un usuario dentro de la fuente de datos con el mismo  número de teléfono");
	
	
	
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
