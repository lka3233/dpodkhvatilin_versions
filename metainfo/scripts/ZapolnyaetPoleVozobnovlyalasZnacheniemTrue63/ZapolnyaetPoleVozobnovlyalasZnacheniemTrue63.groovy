//PartNumber: SCRIPTSD4000059
//Автор: sefimov
//Дата создания: 09.11.2012
//Назначение:
/**
 * Заполнение атрибута объекта над которым совершается дейсвтие (subject) значением константой.
 */
//Версия: 4.0
//Категория: Статусы запроса, действие на вход/выход из статуса

//ПАРАМЕТРЫ------------------------------------------------------------

// код заполняемого атрибута
def ATTR_CODE = "resumed";

// примеры для различных типов атрибутов
// логический атрибут 
def ATTR_VALUE = true; // или false
// Вещественное число
// 123.45
// Целое число
// 123
// Строка / Текст
// "text"
// Набор ссылок на БО
// ["uuid1", "uuid2", "..."]
// Ссылка на БО / Агрегируемый атрибут
// "uuid"
// Набор элементов справочника
// ["catalogCode1", "catalogCode2", "..."]
// Элемент справочника
// "catalogCode"

//ОСНОВНОЙ БЛОК--------------------------------------------------------
utils.edit(subject, [(ATTR_CODE) : ATTR_VALUE]);