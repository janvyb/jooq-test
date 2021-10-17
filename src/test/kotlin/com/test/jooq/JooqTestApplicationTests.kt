package com.test.jooq

import com.test.jooq.generated.enums.EEnum
import com.test.jooq.generated.indexes.U_VARIANT_A
import com.test.jooq.generated.tables.records.TestRecord
import com.test.jooq.generated.tables.references.TEST
import io.zonky.test.db.AutoConfigureEmbeddedDatabase
import org.jooq.DSLContext
import org.jooq.InsertResultStep
import org.jooq.InsertReturningStep
import org.jooq.conf.ParamType
import org.jooq.impl.DSL
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.test.context.ActiveProfiles
import java.util.*

@ActiveProfiles("test")
@SpringBootTest(classes = [JooqTestApplication::class])
@AutoConfigureEmbeddedDatabase(provider = AutoConfigureEmbeddedDatabase.DatabaseProvider.ZONKY)
class JooqTestApplicationTests(
    @Autowired
    private val jooq: DSLContext
) {

    @Test
    fun testThisFails() {
        query().fetch()
    }

    @Test
    fun testThisWorksForSomeReason() {
        val sql = query().getSQL(ParamType.INLINED)
        jooq.resultQuery(sql)
            .fetch()
    }

    private fun query(): InsertResultStep<TestRecord> {
        val rec = TestRecord().apply {
            discriminator = EEnum.A
            nullableColumn = null
            notNullColumn = "Hello World"
        }
        val recWithId = rec.copy().apply {
            id = UUID.randomUUID().toString()
        }

        return jooq.insertInto(TEST)
            .set(recWithId)
            .onConflict(U_VARIANT_A.fields.map { DSL.field(it.name) })
            .where(TEST.DISCRIMINATOR.eq(EEnum.A))
            .doUpdate()
            .set(rec)
            .returning(TEST.ID)
    }
}
