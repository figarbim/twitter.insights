/*
 * Copyright (C) 2011 lightcouch.org
 * Copyright (c) 2015 IBM Corp. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

package com.cloudant.client.org.lightcouch;

import java.util.ArrayList;
import java.util.List;

/**
 * Query parameters to append to find requests.
 * <p>Example:
 * <pre>
 * dbClient.find(Foo.class, "doc-id", new Params().revsInfo().attachments());
 * </pre>
 *
 * @author Ahmed Yehia
 * @see CouchDatabaseBase#find(Class, String, Params)
 * @since 0.0.6
 */
public class Params {

    private List<Param> params = new ArrayList<Param>();

    public Params revsInfo() {
        params.add(new Param("revs_info", true));
        return this;
    }

    public Params attachments() {
        params.add(new Param("attachments", true));
        return this;
    }

    public Params revisions() {
        params.add(new Param("revs", true));
        return this;
    }

    public Params rev(String rev) {
        params.add(new Param("rev", rev));
        return this;
    }

    public Params conflicts() {
        params.add(new Param("conflicts", true));
        return this;
    }

    public Params localSeq() {
        params.add(new Param("local_seq", true));
        return this;
    }

    public Params addParam(String name, String value) {
        params.add(new Param(name, value));
        return this;
    }

    public List<String> getParams() {
        if (params.isEmpty()) {
            return null;
        }

        List<String> result = new ArrayList<String>();
        for (Param param : params) {
            result.add(param.toURLEncodedString());
        }
        return result;
    }

    public int size() {
        return params.size();
    }

    public Param get(int index) {
        return params.get(index);
    }

    public void addAll(Params params) {
        this.params.addAll(params.params);
    }

    /**
     * If this object already contains a parameter whose name matches {@code name}, replace the
     * existing value with {@code value} for the first instance of parameter {@code name}.
     * Otherwise, add a parameter with the new {@code name} and {@code value}.
     *
     * @param name  The name of the parameter to replace/add.
     * @param value The new value of the parameter.
     */
    public void replaceOrAdd(String name, String value) {
        boolean found = false;
        for (Param param : params) {
            if (param.getKey().equals(name)) {
                param.setValue(value);
                found = true;
                break;
            }
        }
        if (!found) {
            addParam(name, value);
        }
    }
}
