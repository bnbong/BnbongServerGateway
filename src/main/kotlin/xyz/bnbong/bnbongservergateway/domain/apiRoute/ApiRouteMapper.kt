package xyz.bnbong.bnbongservergateway.domain.apiRoute

import io.r2dbc.spi.Row
import io.r2dbc.spi.RowMetadata
import org.springframework.stereotype.Component
import xyz.bnbong.bnbongservergateway.domain.method.Method
import xyz.bnbong.bnbongservergateway.domain.serviceInfo.ServiceInfo
import java.util.function.BiFunction

@Component
class ApiRouteMapper : BiFunction<Row, RowMetadata, ApiRoute>{
    override fun apply(row: Row, rowMetadata: RowMetadata): ApiRoute {
        return ApiRoute(
            id = row.get("API_ROUTE_PK", Int::class.java)!!,
            path = row.get("API_ROUTE_PATH", String::class.java)!!,
            priority = row.get("PRIORITY", Int::class.java)!!,
            method = Method(
                id = row.get("METHOD_PK", Int::class.java)!!,
                name = row.get("METHOD_NM", String::class.java)!!
            ),
            service = ServiceInfo(
                id = row.get("SERVICE_PK", Int::class.java)!!,
                name = row.get("SERVICE_NM", String::class.java)!!,
                domain = row.get("SERVICE_DOMAIN", String::class.java)!!,
                index = row.get("SERVICE_INDEX", String::class.java)
            )
        )
    }
}