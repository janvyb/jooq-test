/*
 * This file is generated by jOOQ.
 */
package com.test.jooq.generated.indexes


import com.test.jooq.generated.tables.Test

import org.jooq.Index
import org.jooq.impl.DSL
import org.jooq.impl.Internal



// -------------------------------------------------------------------------
// INDEX definitions
// -------------------------------------------------------------------------

val U_VARIANT_A: Index = Internal.createIndex(DSL.name("u_variant_a"), Test.TEST, arrayOf(Test.TEST.NOT_NULL_COLUMN, Test.TEST.DISCRIMINATOR), true)
val U_VARIANT_B: Index = Internal.createIndex(DSL.name("u_variant_b"), Test.TEST, arrayOf(Test.TEST.NULLABLE_COLUMN, Test.TEST.NOT_NULL_COLUMN, Test.TEST.DISCRIMINATOR), true)