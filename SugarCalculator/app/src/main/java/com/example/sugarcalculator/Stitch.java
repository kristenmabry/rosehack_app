package com.example.sugarcalculator;

import com.mongodb.stitch.android.core.Stitch;
import com.mongodb.stitch.android.core.StitchAppClient;
import com.mongodb.stitch.android.services.mongodb.remote.RemoteMongoClient;
import com.mongodb.stitch.android.services.mongodb.remote.RemoteMongoCollection<DocumentT>

public class StitchClass {

    final StitchAppClient client =
            Stitch.initializeDefaultAppClient("rosehackapp-bieqd");

    final RemoteMongoClient mongoClient =
            client.getServiceClient(RemoteMongoClient.factory, "roseHackAtlas");

    final RemoteMongoCollection<DocumentT> coll =
            mongoClient.getDatabase("User_Info_db").getCollection("User_Info_Collection");


}
