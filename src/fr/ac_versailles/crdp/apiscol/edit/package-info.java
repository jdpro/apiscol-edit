/*
 */
/**
 * 
 * <p>
 * Apiscol-Edit Web Service is identified by the <em>/edit</em>
 * root path. It is an entry point for all writing operations in other web services.
 * 
 * 
 *  </p>
 *  <section class="attention">
 *  <h2>Apiscol unique writing proxy strategy </h2>
 *  <p>ApiScol Edit acts as a proxy for all write operations. For example, if you intend to modify a metadata entry, you will most of the time not adress directly:
 *  <br/>
 *  <code>PUT http://my.apiscol.server/meta/5808af38-9f5a-4e6a-b871-3154bcc1f963</code><br/>
 *  <p>but :
 *  <br/>
 *  <code>PUT https://my.apiscol.server/edit/meta/5808af38-9f5a-4e6a-b871-3154bcc1f963</code><br/>
 *  </p>
 *  </section>
 *  <section class="attention">
 *  <h2>Apiscol Edit and optimistic concurrency </h2>
 *  <p>For all update requests, Apiscol Edit will require you to provide an eTag
 *  corresponding to the current state of the resource as <code>"If-match"</code> HTTP request header.
 *  For metadata and packages, this eTag is available in the  <code>"updated"</code> ATOM fiels of the response.
 *  For example, supposing you requested this URI with  the application/xml <code>'Accept'</code> header: <br/>
 *  <code>GET http://my.apiscol.server/meta/5808af38-9f5a-4e6a-b871-3154bcc1f963</code><br/>
 *  You got this information in the ATOM representation : <br/>
 *  <code>&lt;updated&gt;2013-03-04T17:35:05.000+01:00&lt;/updated&gt;</code><br/>
 * 	The edit URI of the rest resource was provided in the ATOM representation too as 
 *  in a <code>'Link'</code> element with "edit" <code>'rel'</code> attribute:<br/>
 *  &lt;link href="https://178.32.219.182:8443/edit/meta/a23d4b96-dc83-4ad3-88ad-2dbf43068d44" rel="edit" type="application/atom+xml"/&gt;<br/>
 *  In order to update the resource, just call the edit link with a PUT HTTP verb :<br/>
 *  <code>https://178.32.219.182:8443/edit/meta/a23d4b96-dc83-4ad3-88ad-2dbf43068d44</code><br/>
 *  Join the eTag as If-Match field :<br/>
 *  <code>If-match	2013-03-04T17:35:05.000+01:00</code><br/>

 *  </section>
 */

package fr.ac_versailles.crdp.apiscol.edit;