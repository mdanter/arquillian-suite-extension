package org.eu.ingwar.tools.arquillian.extension.suite;

/*
 * #%L
 * Arquillian suite extension
 * %%
 * Copyright (C) 2013 Ingwar & co.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.eu.ingwar.tools.arquillian.extension.suite.annotations.ExtendedSuiteScoped;
import org.jboss.arquillian.core.spi.HashObjectStore;
import org.jboss.arquillian.core.spi.context.AbstractContext;
import org.jboss.arquillian.core.spi.context.ObjectStore;

import java.lang.annotation.Annotation;

/**
 * Implementation of ExtendedScopeContext.
 *
 * @author Karol Lassak 'Ingwar'
 */
public class ExtendedSuiteContextImpl extends AbstractContext<String> implements ExtendedSuiteContext {

    private static final String SUITE_CONTEXT_ID = "extendedSuite";

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<? extends Annotation> getScope() {
        return ExtendedSuiteScoped.class;
    }

    /**
     * There can only one Suite active, so we hard code the id to "Suite".
     * 
     * {@inheritDoc}
     */
    @Override
    public void activate() {
        super.activate(SUITE_CONTEXT_ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void destroy() {
        super.destroy(SUITE_CONTEXT_ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ObjectStore createNewObjectStore() {
        return new HashObjectStore();
    }
}
