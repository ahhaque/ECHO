/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package change_point_detection;

import org.apache.commons.math.distribution.BetaDistributionImpl;

/**
 *
 * @author axh129430
 */
public class CusumElement {
    private BetaDistributionImpl preChangeDist;
    private Double preChangeMean;
    private BetaDistributionImpl postChangeDist;
    private Double cusumScore;
    
    public CusumElement(double alphaPreChange, double betaPreChange, double alphaPostChange, double betaPostChange, double preChangeMean, double cusumScore){
        this.preChangeDist = new BetaDistributionImpl(alphaPreChange, betaPreChange);
        this.postChangeDist = new BetaDistributionImpl(alphaPostChange, betaPostChange);
        this.preChangeMean = preChangeMean;
        this.cusumScore = cusumScore;
    }
    
    public CusumElement(BetaDistributionImpl preChangeDist, BetaDistributionImpl postChangeDist, double preChangeMean, double cusumScore){
        this.preChangeDist = preChangeDist;
        this.postChangeDist = postChangeDist;
        this.preChangeMean = preChangeMean;
        this.cusumScore = cusumScore;
    }
    
    public CusumElement()
    {
        this.preChangeDist = null;
        this.postChangeDist = null;
        this.preChangeMean = Double.MIN_VALUE;
        this.cusumScore = Double.MIN_VALUE;
    }
    
    public BetaDistributionImpl getPreChangeDist(){
        return this.preChangeDist;
    }
    
    public BetaDistributionImpl getPostChangeDist(){
        return this.postChangeDist;
    }
    
    public Double getPreChangeMean(){
        return this.preChangeMean;
    }
    
    public Double getCusumScore(){
        return this.cusumScore;
    }
    
    public void setPreChangeDist(BetaDistributionImpl preChangeDist){
        this.preChangeDist = preChangeDist;
    }    
    
    public void setPostChangeDist(BetaDistributionImpl postChangeDist){
        this.postChangeDist = postChangeDist;
    }  
    
    public void setPreChangeMean(Double preChangeMean){
        this.preChangeMean = preChangeMean;
    }
    
    public void setCusumScore(Double cusumScore){
        this.cusumScore = cusumScore;
    }
    
    public void clear(){
        this.preChangeDist = null;
        this.postChangeDist = null;
        this.preChangeMean = Double.MIN_VALUE;
        this.cusumScore = Double.MIN_VALUE;
    }
}
