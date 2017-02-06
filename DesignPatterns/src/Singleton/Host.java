/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

/**
 *
 * @author Mhatem
 */
public class Host {
        private static Host _instance = null;
        private Host(){
            
        }
        public static Host getInstance(){
            if(_instance == null){
                _instance = new Host();
            }
            return _instance;
        }
}
