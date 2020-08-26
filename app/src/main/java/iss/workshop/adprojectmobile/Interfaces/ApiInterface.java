package iss.workshop.adprojectmobile.Interfaces;

import java.util.List;

import iss.workshop.adprojectmobile.model.DisbursementDetail;
import iss.workshop.adprojectmobile.model.DisbursementList;
import iss.workshop.adprojectmobile.model.Employee;
import iss.workshop.adprojectmobile.model.Requisition;
import iss.workshop.adprojectmobile.model.RequisitionDetail;
import iss.workshop.adprojectmobile.model.Stationery;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {
    String url = "https://10.0.2.2:5001/api/";

    @GET("store/retrieval/{id}") //store/retrieval/15
    Call<List<RequisitionDetail>> getPendingRequisition(@Path("id") int id);

    @GET("store/stationeries")
    Call<List<Stationery>> getAllStationery();

    @GET("store/disbursements/{id}")
    Call<List<DisbursementList>> getAllDisbursementLists(@Path("id") int id); //find by clerk ID

    @GET("store/departmentReps")
    Call<List<Employee>> getAllDepartmentReps();

    @GET("store/disbursementdetail/{id}")
    Call<List<DisbursementDetail>> getAllDisbursementDetail(@Path("id") int id); //disbursement list ID

    @GET("store/disbursementlist/{id}")
    Call<DisbursementList> getDisbursementList(@Path("id") int id);


    @Headers({"Content-Type: application/json"})
    @POST("store/getretrieval")
    Call<Requisition> sendRequisitionToProcess(@Body Requisition requisitions);

    @Headers({"Content-Type: application/json"})
    @POST("store/processRetrieval")
    Call<List<DisbursementList>> processRetrieval(@Body List<RequisitionDetail> requisitions);

    @Headers({"Content-Type: application/json"})
    @POST("login/post")
    Call<Employee> login(@Body Employee employee);


}
