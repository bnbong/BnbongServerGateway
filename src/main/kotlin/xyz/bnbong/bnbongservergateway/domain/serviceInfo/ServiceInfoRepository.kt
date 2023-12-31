package xyz.bnbong.bnbongservergateway.domain.serviceInfo

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ServiceInfoRepository: ReactiveCrudRepository<ServiceInfo, Int>, ServiceInfoCustomRepository