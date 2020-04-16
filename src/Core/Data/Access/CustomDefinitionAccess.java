package Core.Data.Access;

import Core.Data.Models.Definition;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class CustomDefinitionAccess extends CustomAccess<Definition,Long> {

    public CustomDefinitionAccess(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, Definition.class);
    }
}
