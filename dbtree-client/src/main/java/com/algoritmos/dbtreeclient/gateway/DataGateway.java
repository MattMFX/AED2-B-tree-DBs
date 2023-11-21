package com.algoritmos.dbtreeclient.gateway;

public interface DataGateway {

        public String insert(Object data);
        public String search(String id);
        public String delete(String id);
}
