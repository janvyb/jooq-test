/*
 * This file is generated by jOOQ.
 */
package com.test.jooq.generated.tables


import com.test.jooq.generated.Public
import com.test.jooq.generated.enums.EEnum
import com.test.jooq.generated.indexes.U_VARIANT_A
import com.test.jooq.generated.indexes.U_VARIANT_B
import com.test.jooq.generated.keys.TEST_PKEY
import com.test.jooq.generated.tables.records.TestRecord

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Index
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row4
import org.jooq.Schema
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class Test(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, TestRecord>?,
    aliased: Table<TestRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<TestRecord>(
    alias,
    Public.PUBLIC,
    child,
    path,
    aliased,
    parameters,
    DSL.comment(""),
    TableOptions.table()
) {
    companion object {

        /**
         * The reference instance of <code>public.test</code>
         */
        val TEST = Test()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<TestRecord> = TestRecord::class.java

    /**
     * The column <code>public.test.id</code>.
     */
    val ID: TableField<TestRecord, String?> = createField(DSL.name("id"), SQLDataType.CLOB.nullable(false), this, "")

    /**
     * The column <code>public.test.nullable_column</code>.
     */
    val NULLABLE_COLUMN: TableField<TestRecord, String?> = createField(DSL.name("nullable_column"), SQLDataType.CLOB, this, "")

    /**
     * The column <code>public.test.not_null_column</code>.
     */
    val NOT_NULL_COLUMN: TableField<TestRecord, String?> = createField(DSL.name("not_null_column"), SQLDataType.CLOB.nullable(false), this, "")

    /**
     * The column <code>public.test.discriminator</code>.
     */
    val DISCRIMINATOR: TableField<TestRecord, EEnum?> = createField(DSL.name("discriminator"), SQLDataType.VARCHAR.nullable(false).asEnumDataType(com.test.jooq.generated.enums.EEnum::class.java), this, "")

    private constructor(alias: Name, aliased: Table<TestRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<TestRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>public.test</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>public.test</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>public.test</code> table reference
     */
    constructor(): this(DSL.name("test"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, TestRecord>): this(Internal.createPathAlias(child, key), child, key, TEST, null)
    override fun getSchema(): Schema = Public.PUBLIC
    override fun getIndexes(): List<Index> = listOf(U_VARIANT_A, U_VARIANT_B)
    override fun getPrimaryKey(): UniqueKey<TestRecord> = TEST_PKEY
    override fun getKeys(): List<UniqueKey<TestRecord>> = listOf(TEST_PKEY)
    override fun `as`(alias: String): Test = Test(DSL.name(alias), this)
    override fun `as`(alias: Name): Test = Test(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): Test = Test(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): Test = Test(name, null)

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row4<String?, String?, String?, EEnum?> = super.fieldsRow() as Row4<String?, String?, String?, EEnum?>
}