<!--Download CV Modal-->
<div class="modal fade" id="statusChangeModal" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-body">
                <div class="form-group">
                    <label>Change selected application(s) to:</label>
                    <div>
                        <select name="status" class="form-control">
                            <option value="Submitted">Submitted</option>
                            <option value="Reviewed" >Reviewed</option>
                            <option value="Confirmed">Confirmed</option>
                            <option value="Rejected">Rejected</option>
                        </select>
                    </div>
                </div>
            </div>
            
            <div class="modal-footer">
                <button id="download-submit" type="submit" class="btn btn-primary">Apply Changes</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
            </div>
        </div>
    </div>
</div>