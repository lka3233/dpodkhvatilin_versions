//Назначение:
/**
 * Скрипт для вывода параметров 
 * "Дата решения с" - дата и время 00:00, обязательный
 * "Дата решения по" - дата и время 23:59, обязательный
 * "Учитывать заявки по всем услугам" - тип "Логический", по умолчанию – "нет"
 * "Или выберите конкретные услуги" - тип "Набор ссылок на объекты" класса "Услуга", по умолчанию – пусто, есть сложная форма
 * "Учитывать заявки без услуги" - тип "Логический", по умолчанию – "нет"
 * "Учитывать заявки по всем контрагентам" - тип "Логический", по умолчанию – "нет"
 * "Или выберите конкретных контрагентов" - тип "Набор ссылок на объекты" класса "Отдел", по умолчанию – пусто, есть сложная форма
 * "Учитывать заявки отделов/компаний, вложенных в выбранные" - тип "Логический", по умолчанию – "нет"
 * "Учитывать заявки без контрагента" - тип "Логический", по умолчанию – "нет"  
 */
//ОСНОВНОЙ БЛОК--------------------------------------------------------

def getParameters() {
  return [
    api.parameters.getDateTime("dateFrom","Дата решения с", null, 'startOfDay', true),
  api.parameters.getDateTime("dateTo", "Дата решения по", null, 'endOfDay', true),
    api.parameters.getBoolean("allService", "Учитывать заявки по всем услугам", false),
    api.parameters.getObjects("pService", "Или выберите конкретные услуги", "slmService", "", ['attrGroupCode' : '6ee38cb6-9554-41d2-8d55-873b51adc032']),
    api.parameters.getBoolean("bService", "Учитывать заявки без услуги", false),
    api.parameters.getBoolean("allOU", "Учитывать заявки по всем контрагентам", false),
    api.parameters.getObjects("pOu", "Или выберите конкретных контрагентов", "ou", "", ['attrGroupCode' : 'edcfcd28-3de9-4a5c-bab7-3b772a727486']),
    api.parameters.getBoolean("bOu", "Учитывать заявки отделов/компаний, вложенных в выбранные", false),
    api.parameters.getBoolean("bClientIsEmpty", "Учитывать заявки без контрагента", false)
  ] as List
}

table.rows.each {
  row ->
  // Для каждой строки основного отчета заполняем ссылку на заявку
  if(row.id != null){
    row.sc_url = api.web.open('serviceCall$' + row.id.toString())
  }
}

// Текущая дата - дата формирования отчета
table.addValue('rDate', new Date())