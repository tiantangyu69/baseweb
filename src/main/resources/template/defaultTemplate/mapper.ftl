<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${className}Mapper">
    <cache />
    
    <insert id="insert" parameterType="${className}" useGeneratedKeys="true" keyProperty="id">
        insert into ${entityName}
        (<#list columnList as f><#if f_has_next>${f.name}, </#if><#if !f_has_next>${f.name}</#if></#list>)
        values
        (<#list columnList as f><#if f_has_next>${'#'}{${f.name}}, </#if><#if !f_has_next>${'#'}{${f.name}}</#if></#list>)
    </insert>
    
    <select id="queryByCondition" parameterType="map" resultType="${className}">
        select * from ${entityName}
        <where>
            <include refid="condition"/>
            <include refid="andLikeCondition"/>
            <include refid="startLikeCondition"/>
        </where>
        <if test="orderBy==null and sortBy==null">
            order by id desc
        </if>
        <if test="orderBy!=null">
            order by ${'$'}{orderBy}
        </if>
        <if test="orderBy!=null and sortBy!=null">
            ${'$'}{sortBy}
        </if>
        <if test="beginRow==null or pageSize==null">
            limit 0,10
        </if>
        <if test="beginRow!=null and pageSize!=null">
            limit ${'#'}{beginRow},${'#'}{pageSize}
        </if>
    </select>
    
    <select id="findAll" parameterType="map" resultType="${className}">
        select * from ${entityName}
        <where>
            <include refid="condition"/>
            <include refid="andLikeCondition"/>
        </where>
    </select>
    
    <select id="distinct" parameterType="map" resultType="${className}">
        select Distinct * from ${entityName}
        <where>
            <include refid="condition"/>
            <include refid="andLikeCondition"/>
            <include refid="startLikeCondition"/>
        </where>
        <if test="orderBy==null and sortBy==null">
            order by id desc
        </if>
        <if test="orderBy!=null">
            order by ${'$'}{orderBy}
        </if>
        <if test="orderBy!=null and sortBy!=null">
            ${'$'}{sortBy}
        </if>
        <if test="beginRow==null or pageSize==null">
            limit 0,10
        </if>
        <if test="beginRow!=null and pageSize!=null">
            limit ${'#'}{beginRow},${'#'}{pageSize}
        </if>
    </select>
    
    <select id="find" parameterType="map" resultType="${className}">
        select * from ${entityName}
        <where>
            <include refid="condition"/>
            <include refid="andLikeCondition"/>
            <include refid="startLikeCondition"/>
        </where>
    </select>
    
    <select id="count" parameterType="map" resultType="int">
        select count(0) from ${entityName}
        <where>
            <include refid="condition"/>
            <include refid="andLikeCondition"/>
            <include refid="startLikeCondition"/>
        </where>
    </select>
    
    <select id="fetch" parameterType="int" resultType="${className}">
        select * from ${entityName} where id=${'#'}{id}
    </select>
    
    <select id="fetchByCondition" parameterType="int" resultType="${className}">
        select * from ${entityName}
        <where>
            <include refid="condition"/>
        </where>
    </select>
    
    <delete id="deleteById" parameterType="int">
        delete from ${entityName} where id=${'#'}{id}
    </delete>
    
    <delete id="deleteByCondition" parameterType="map">
        delete from ${entityName}
        <where>
            <include refid="condition"/>
        </where>
    </delete>
    
    <update id="update" parameterType="${className}">
        update ${entityName}
        <set>
            <#list columnList as f>
                <#if f_has_next>
                    <if test="${f.name} !=null">
                        ${f.name} = ${'#'}{${f.name}},
                    </if>
                </#if>
                <#if !f_has_next>
                    <if test="${f.name} !=null">
                        ${f.name} = ${'#'}{${f.name}}
                    </if>
                </#if>
            </#list>
        </set>
        where id = ${'#'}{id}
    </update>
    
    <sql id="condition">
        <#list columnList as f>
            <if test="${f.name} !=null">
                and ${f.name} = ${'#'}{${f.name}}
            </if>
        </#list>
    </sql>
    
    <sql id="andLikeCondition">
        <#list columnList as f>
            <if test="andLike${f.name ? cap_first}!=null and andLike${f.name ? cap_first}!=''">
                and ${f.name} like CONCAT(CONCAT('%',${'#'}{andLike${f.name ? cap_first}}),'%')
            </if>
        </#list>
    </sql>
    
    <sql id="startLikeCondition">
        <#list columnList as f>
            <if test="startLike${f.name ? cap_first}!=null and startLike${f.name ? cap_first}!=''">
                and ${f.name} like CONCAT(CONCAT(${'#'}{startLike${f.name ? cap_first}}),'%')
            </if>
        </#list>
    </sql>
    
    <update id="setNull" parameterType="map">
        update ${entityName}
        <set>${'$'}{tableField} = null</set>
        <where>
            <if test="id!=null">id = ${'#'}{id}</if>
            <include refid="condition"/>
        </where>
    </update>
    
    <select id="maxInt" parameterType="map" resultType="int">
        select max(${'$'}{tableField}) from ${entityName}
        <where>
            <include refid="condition"/>
            <include refid="andLikeCondition"/>
        </where>
    </select>
</mapper>