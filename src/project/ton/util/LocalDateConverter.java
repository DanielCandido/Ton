package project.ton.util;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date>
{
    @Override
    public Date convertToDatabaseColumn(LocalDate pLocalDate)
    {
        return (pLocalDate == null ? null : Date.valueOf(pLocalDate));
    }
    @Override
    public LocalDate convertToEntityAttribute(Date pDate)
    {
        return (pDate == null ? null : pDate.toLocalDate());
    }
}
